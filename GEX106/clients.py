import socket

HOST = '172.20.83.214'  # endereço IP do servidor
PORT = 5555  # porta usada pelo servidor

def main():
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client_socket.connect((HOST, PORT))
    print(f'Connected to server {HOST}:{PORT}')

    while True:
        message = input('Type a message (or q to quit): ')
        if message == 'q':
            break
        client_socket.sendall(message.encode())  # envia mensagem para o servidor
        data = client_socket.recv(1024)  # recebe resposta do servidor
        print(f'Received from server: {data.decode()}')

    client_socket.close()  # fecha a conexão com o servidor





if __name__ == '__main__':
    main()
    
    
    import socket

HOST = '172.20.83.214'  # endereço IP do servidor
PORT = 5555  # porta usada pelo servidor

def main():
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client_socket.connect((HOST, PORT))
    print(f'Connected to server {HOST}:{PORT}')

    while True:
        message = input('Type a message (or q to quit): ')
        if message == 'q':
            break
        client_socket.sendall(message.encode())  # envia mensagem para o servidor
        data = client_socket.recv(1024)  # recebe resposta do servidor
        print(f'Received from server: {data.decode()}')

    client_socket.close()  # fecha a conexão com o servidor





if __name__ == '__main__':
    main()
