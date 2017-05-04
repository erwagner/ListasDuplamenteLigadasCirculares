package listasduplamenteligadascirculares;

public class ListasDuplamenteLigadasCirculares {

    static No inicio = null;
    
    public static void main(String[] args) {

        int N = 10;
        int S = 2;
        int J = 3;
        
        for(int i=1;i<=N;i++)
            inserir(i);
        
        josephus(S,J);
        
        System.out.println("N: "+N+"\nS: "+S+"\nJ: "+J+"\nVENCEDOR: "+inicio.valor+"\n");
        
        
    }
      
    public static void josephus(int s, int j){
                No temp = inicio.ant;
        while(temp != temp.prox){
             
            //FRENTE
            for(int i=1; i<=s; i++) //1
                 temp = temp.prox; //2
             
             temp.prox.ant = temp.ant;
             temp.ant.prox = temp.prox;
           
             
            //TRAZ
            if(temp!=temp.prox){
                for(int i=1; i<=j; i++) 
                    temp = temp.ant; 
                
                temp.prox.ant = temp.ant;
                temp.ant.prox = temp.prox;
            }

        }
        inicio = temp;
    }
    
    
    public static void inserir(int valor){
        No novo = new No(valor);
        if(inicio == null){
            inicio = novo;
            inicio.prox = inicio;
            inicio.ant = inicio;
        }else{
            novo.prox = inicio;
            novo.ant = inicio.ant;
            inicio.ant.prox = novo;
            inicio.ant = novo;
        }
        
    }
 
    public static void exibir(){
        if(inicio == null)
            System.out.println("Lista Vazia, impossível Exibir");
        else{
            No temp = inicio.prox;
            System.out.println(inicio.valor);
            while(temp!=inicio){
                System.out.println(temp.valor);
                temp = temp.prox;
            }
                
            
        }
    }
}
