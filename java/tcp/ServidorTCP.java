import java.io.*;
import java.net.*;
import java.time.LocalDateTime;

public class ServidorTCP {
    public static void main(String[] args) throws IOException {

        int porta = 5042;

        try (ServerSocket servidor = new ServerSocket(porta)) {

            System.out.println("[TCP] Servidor aguardando conexões na porta " + porta + "...");
            try (
                    Socket cliente = servidor.accept();
                    BufferedReader entrada = new BufferedReader(
                            new InputStreamReader(cliente.getInputStream()));
                    PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true)) {

                System.out.println("[TCP] Cliente conectado: " + cliente.getRemoteSocketAddress());
                String mensagem;
                
                while ((mensagem = entrada.readLine()) != null) {
                    System.out.println("[TCP] Recebido: " + mensagem);

                    if(mensagem.equalsIgnoreCase("hora")) {
                        saida.println("Hora Atual: " + LocalDateTime.now());
                    } else {
                        saida.println("Monitor responde: recebi sua mensagem -> \"" + mensagem + "\"");
                    }
                        
                    if (mensagem.equalsIgnoreCase("sair")) {
                        saida.println("Encerrando conexão. Até mais!");
                        break;
                    }
                }
            }
            System.out.println("[TCP] Servidor encerrado.");
        }
    }
}