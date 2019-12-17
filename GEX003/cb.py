vetor=[]
n=0
y=0
f=0
array=[]
jj=[]
while n<=4:
    x=int(input("informe..".format(n+1)))
    print()
    n=n+1
    vetor.append(x)
while y<=4:
    k=int(input("digite".format(y+1)))
    print()
    y=y+1
    array.append(k)

jj=vetor+array
for c in jj:
    if jj[c]==jj[c]:
        jj[c]=0
print(jj)

  // for(int s=0;s<vetor3.length;s++){
//   if (vetor3[k]==vetor3[k+1]){
//         vetor3[k+1]=0;
//   }
//   System.out.print(vetor3[s]);
// }



// Arrays.sort(vetor1);
// for(int x:vetor1){
//   System.out.print(x + " ");
// }
// Arrays.sort(vetor2);
// for(int y:vetor2){
//   System.out.print(y + " ");
// }

// System.out.print(vetor1);
// System.out.print(vetor2);
