import java.lang.reflect.Method;

public class Pilha <X> implements Cloneable
{
    protected Object [] vetPilha;
    protected int topo;
    protected int tamanho;
    
    public Pilha (int tam) throws Exception
    {
        if(tam <= 0)
            throw new Exception ("Tamanho invalido");
            
        this.tamanho = tam;
        vetPilha = new Object[this.tamanho];
        this.topo = 0;
    }
    
    public void push (X n) throws Exception
    {
        if(this.topo == this.tamanho)
            throw new Exception ("Pilha cheia");
        
        if(n instanceof Cloneable){
            Class classe = n.getClass();
            Class<?>[] parmsFormais = null; //nao possui parametros formais
            Method metodo = classe.getMethod("clone",  parmsFormais);
            Object [] parmsReais = null;//nao possui parametros reais
            this.vetPilha[this.topo] = (X)metodo.invoke(n, parmsReais);
        }
        else{
            this.vetPilha[this.topo] = n;
            this.topo++;   
        }
    }
    
    public X pop () throws Exception
    {
        if(this.topo == 0)
            throw new Exception ("Pilha vazia");
            
        this.topo--;
        return (X) this.vetPilha[this.topo + 1];
    }
    
    public boolean equals (Object obj)
    {
        if(this==obj)
            return true;
      
        if(obj==null)
            return false;
        
        if(!obj instanceof Pilha){
            return false;
        }
        Pilha aux = (Pilha)obj;
        
        if(this.topo != aux.topo)
            return false;
        
        if(this.tamanho != aux.tamanho)
            return false;
            
        for(int i=0;i<=this.topo;i++){
            if(this.vetPilha[i] != aux.vetPilha[i])
                return false;
        }
    }
    
    public String toString ()
    {
        String s = null;
        
        for(int i=0;i<this.tamanho;i++)
            s = s + "[" + this.vetPilha[i] + "]";
            
        return s;
    }
    
    public int hashCode()
    {
        int h = super.hashCode();
        
        
        for(int i=0;i<this.tamanho;i++){
            h = h*13 + new Integer  ((int)this.vetPilha[i]).hashCode();
        }
        h = h*13 +  new Integer  (this.topo).hashCode();
        h = h*13 +  new Integer  (this.tamanho).hashCode();
         
        return h;
    }
    
    public Pilha (Pilha modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception ("Modelo nao fornecido");
            
        this.vetPilha = new Object [modelo.tamanho];
        
        for(int i=0;i<modelo.tamanho;i++){
            if(modelo.vetPilha[i] instanceof Cloneable)
                this.vetPilha[i] =(X) modelo.vetPilha[i].clone();
            else
                this.vetPilha[i] = modelo.vetPilha[i];
                
        this.topo = modelo.topo;
        this.tamanho = modelo.tamanho;
        }
        
        this.topo = modelo.topo;
        this.tamanho = modelo.tamanho;
    }
    
    public Object clone()
    {
        Pilha p = null;
        
        try{
            p = new Pilha (this);
        }
        catch(Exception erro)
        {}
        
        return p;
    }
}
