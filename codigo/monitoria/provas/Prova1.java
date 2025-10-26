package monitoria.provas;

public class Prova1 {
    /**
     * Questao 1
     */
    public float masterDetail(String name) {
        List clients = this.getClients();
        List orders = this.getOrders();
        Client client = null;
        for(Client c : clients) {
            if(name.equalsIgnoreCase(client.getName())) {
                client = c;
                break;
            }
        }

        if (client == null) {
            return -1; // retorna um numero negativo para indicar que o cliente nao existe
        }

        List clientOrders = null;
        for(Order o : orders) {
            if(o.getClientCPF().equals(client.getClientCPF())){
                clientOrders.append(o);
            }
        }
        if(clientOrders == null) {
            return 0;
        } else {
            float sum = 0;
            for(Order o : clientOrders) {
                sum += o.getValue();
            }
            return sum;
        }
    }

    /**
     * Questao 2
     */
    public List getCulturaisEsportivas(List a, List b, List c) {
        List ab = new List();
        while()
    }
}
