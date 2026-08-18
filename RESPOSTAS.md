# Roteiro 3 - gRPC
## Perguntas da seção 4.1
1. Sim, isso **prejudica** a transparência de localização pois o cliente precisa conhecer a endereço do servidor para mandar as requisições.
2. Não, e isso é **presença** de transparência de acesso, pois tanto as requisições locais quanto remotas usam a mesma forma de interpretar as mensagens.
3. Caso o servidor mudasse de máquina, seria preciso alterar o endereço do servidor no código cliente de todas as soluções. 
