const fs = require('fs');
const chalk = require('chalk');
const YAML = require('yaml');

const { Client } = require('pg')

const types = {
  START_TRANSACTION: 'START_TRANSACTION',
  DO_TRANSACTION: 'DO_TRANSACTION',
  COMMIT_TRANSACTION: 'COMMIT_TRANSACTION',
  CHECKPOINT: 'CHECKPOINT',
  END_CHECKPOINT: 'END_CHECKPOINT'
}

async function main() {
  const file = readFile();

  await populateDatabase(file);

  const log = parseFile(file);

  const { itemsToVerify } = getItemsToVerify(log);

  // Get the columns and its values
  const { rows: [dbTable] } = await query('SELECT * FROM "table" WHERE id = 1');

  const items = getItemsToUpdateOnDb(dbTable, itemsToVerify);

  saveOutputLog(items);

  await saveChangesOnDB(items);
  logChanges(items, getTransactionsTypeList(log, items));
}


function getTransactionsTypeList(log, items) {
  const rawTransactionList = log.map(transaction => transaction.transaction).filter(item => item !== undefined);
  const transactionList = [...new Set(rawTransactionList)];
  
  const redoItems = [...new Set(items.map(item => item.transactionList).flat())];
  const uncommitedItems = [...new Set(items.map(item => item.uncommitedItems).flat())];

  console.log(uncommitedItems);

  const checkpointItems = transactionList.filter(x => ![...redoItems, ...uncommitedItems].includes(x));

  return transactionList.map(item => {
    const isCheckpoint = checkpointItems.indexOf(item) >= 0;
    const isCommited = redoItems.indexOf(item) >= 0;
    const isUncommitedItems = uncommitedItems.indexOf(item) >= 0;
    
    if(isCheckpoint) {
      return {
        transaction: item,
        type: 'CHECKPOINT'
      }
    }

    if(isCommited) {
      return {
        transaction: item,
        type: 'REDO'
      }
    }

    if(isUncommitedItems) {
      return {
        transaction: item,
        type: 'NÃO COMITADO'
      }
    }
    
  });
}

function getItemsToVerify(log) {
  const checkpoints = getValidCheckpoints(log);

  const itemsList = checkpoints.map(checkpoint => {
    return getTransactionsCommited(log.slice(0, checkpoint.logPosition));
  })

  const itemsToIgnore = [...new Set(itemsList.flat())];

  return { checkpoints, itemsToVerify: log.filter(item => itemsToIgnore.find(i => item === i) === undefined) }
}

function saveOutputLog(items) {
  if (!fs.existsSync('./.output')) {
    fs.mkdirSync('./.output');
  }

  const doc = new YAML.Document();
  doc.contents = items;

  const fileName = `.output/${Date.now()}`;

  fs.writeFileSync(`${fileName}.json`, JSON.stringify(items, null, 2));
  fs.writeFileSync(`${fileName}.yaml`, doc.toString());
}

async function saveChangesOnDB(items) {
  await Promise.all([
    ...items.filter(item => item.commited).map(item =>
      query(`UPDATE "table" SET "${item.column}" = ${item.newValueList.slice(-1)[0]} WHERE "id" = 1`)
    )
  ]);
}

function logChanges(items, secondPrintData) {
  const mainText = '---------------------------- ITEMS  ----------------------------'
  clearConsoleAndScrollbackBuffer();
  // console.log(chalk.bgGreen(mainText));
  items.filter(item => item.commited).forEach(item => {
    const output = `Coluna: ${item.column} | OLD: ${item.oldValue} | NEW ${item.newValueList.slice(-1)[0]}`;
    const emptyCharacters = mainText.length - output.length;

    // console.log(chalk.bgGreenBright(output + ' '.repeat(emptyCharacters)));
    item._raw.forEach(raw => {
      const output = `Transação: ${raw.transaction} alterou para: ${raw.value}`;
      const emptyCharacters = mainText.length - output.length;

      // console.log(chalk.bgGreen(output + ' '.repeat(emptyCharacters)));
    })
    // console.log(chalk.bgGreen('-').repeat(mainText.length));
  });

  console.log('\n\n\n');

  secondPrintData.forEach(item => console.log(`Transação ${item.transaction} ${item.type !== 'REDO' && item.type !== 'NÃO COMITADO'? 'não ' : ''}realizou Redo`))
}

function getItemsToUpdateOnDb(dbTable, itemsToVerify) {
  return Object.keys(dbTable).slice(1).reduce((accumulator, key) => {
    const possibleItemList = itemsToVerify.filter(transaction => transaction.column === key);

    if (possibleItemList.length === 0) {
      return accumulator;
    }

    //lista das transações 
    const transactionItems = possibleItemList.map(transaction => {
      const transactionIndex = itemsToVerify.findIndex(item => item === transaction);
      const commitIndex = itemsToVerify.findIndex(item => item.type === types.COMMIT_TRANSACTION && item.transaction === transaction.transaction);

      return {
        transaction,
        commit: transactionIndex < commitIndex && commitIndex >= 0,
      }
    });

    const itemList = transactionItems.filter(item => item.commit).map(item => item.transaction)

    const newValueList = itemList.map(transaction => transaction.value);
    const oldValue = dbTable[key];

    const updatedDb = !newValueList.reduce((changed, currentValue) => changed && (currentValue == oldValue), true);

    accumulator.push({
      column: key,
      newValueList,
      oldValue,
      transactionList: itemList.map(item => item.transaction),
      uncommitedItems: possibleItemList.filter(x => !itemList.includes(x)).map(i => i.transaction),
      updatedDb,
      commited: itemList.length !== 0,
      _raw: itemList
    });

    return accumulator;
  }, []);
}

function getTransactionsCommited(log) {
  const commitedItems = log.filter(item => item.type === types.COMMIT_TRANSACTION);

  const itemsToVerify = log.reduce((accumulator, current) => {
    if (!(current.type === types.DO_TRANSACTION)) {
      return accumulator;
    }

    if (commitedItems.findIndex(item => item.transaction === current.transaction) < 0) {
      return accumulator;
    }

    accumulator.push(current);

    return accumulator;
  }, []);
  return itemsToVerify;
}

function getValidCheckpoints(log) {
  const checkpointItems = log.filter(item => item.type === types.CHECKPOINT);

  return checkpointItems.map(checkpoint => {
    checkpointIndex = log.indexOf(checkpoint);
    const hasCheckpoint = log.slice(checkpointIndex).findIndex(logItem => logItem.type === types.END_CHECKPOINT)
    return hasCheckpoint >= 0 ? { checkpoint, logPosition: checkpointIndex } : undefined;
  }).filter(item => item !== undefined);
}

async function populateDatabase(file) {
  const parsedHeader = parseHeader(file);

  const { A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z} = parsedHeader;

  await query(`
  INSERT INTO public."table" (id, "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z") VALUES (1, ${A ? A : null}, ${B ? B : null}, ${C ? C : null}, ${D ? D : null}, ${E ? E : null}, ${F ? F : null}, ${G ? G : null}, ${H ? H : null}, ${I ? I : null}, ${J ? J : null}, ${K ? K : null}, ${L ? L : null}, ${M ? M : null}, ${N ? N : null}, ${O ? O : null}, ${P ? P : null}, ${Q ? Q : null}, ${R ? R : null}, ${S ? S : null}, ${T ? T : null}, ${U ? U : null}, ${V ? V : null},${W ? W : null}, ${X ? X : null}, ${Y ? Y : null}, ${Z ? Z : null})
  ON CONFLICT (id) DO UPDATE 
  SET "A" = excluded."A",
    "B" = excluded."B",
    "C" = excluded."C",
    "D" = excluded."D",
    "E" = excluded."E",
    "F" = excluded."F",
    "G" = excluded."G",
    "H" = excluded."H",
    "I" = excluded."I",
    "J" = excluded."J",
    "K" = excluded."K",
    "L" = excluded."L",
    "M" = excluded."M",
    "N" = excluded."N",
    "O" = excluded."O",
    "P" = excluded."P",
    "Q" = excluded."Q",
    "R" = excluded."R",
    "S" = excluded."S",
    "T" = excluded."T",
    "U" = excluded."U",
    "V" = excluded."V",
    "W" = excluded."W",
    "X" = excluded."X",
    "Y" = excluded."Y",
    "Z" = excluded."Z"
  WHERE "table".id = 1`
  );
}

async function query(sql) {
  const client = new Client({
    database: 'db2', host: 'localhost', user: 'postgres', password: 'xxxx'
  });

  await client.connect();

  const res = await client.query(sql);

  await client.end();

  return res;
}

function parseFile(file) {
  const rawExpressions = parseExpressions(file);

  return rawExpressions.map(item => {
    if (/^\s*start\s*t/gmi.test(item)) {
      return {
        type: types.START_TRANSACTION,
        transaction: item.split(' ')[1].trim()
      };
    }

    if (/^\s*t\d+/gmi.test(item)) { // <T1,1,A,20>
      const [transactionName, id, column, value] = item.split(',').map(i => i.trim());

      return {
        type: types.DO_TRANSACTION,
        transaction: transactionName,
        column: column,
        value: value,
        id: id,
      };
    }

    if (/^\s*commit/gmi.test(item)) {
      return {
        type: types.COMMIT_TRANSACTION,
        transaction: item.split(' ')[1].trim()
      };
    }

    if (/Start\s*CKPT/gmi.test(item)) {
      const regex = /\((.*)\)/gmi;

      return {
        type: types.CHECKPOINT,
        transactionList: regex.exec(item)[1].split(',').map(i => i.trim())
      };
    }

    if (/End\s*CKPT/gmi.test(item)) {
      return {
        type: types.END_CHECKPOINT,
      };
    }
  });
}

function parseExpressions(file) {
  const result = [];

  for (const match of file.matchAll(/<(.*)>/gmi)) {
    result.push(match[1]);
  }
  return result;
}

function readFile() {
  const file = fs.readFileSync('./file', 'utf8').trimLeft().trimRight();
  return file;
}

function parseHeader(file) {
  const header = file.split('\n').shift();

  return Object.assign({}, ...header.split('|').map(item => {
    const trimedItem = item.trim();

    const [key, value] = trimedItem.split('=');

    return {
      [key]: value
    };
  }));
}

function clearConsoleAndScrollbackBuffer() {
  process.stdout.write("\u001b[3J\u001b[2J\u001b[1J"); console.clear();
}

main();
