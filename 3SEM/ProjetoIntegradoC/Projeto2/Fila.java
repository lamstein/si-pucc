import java.lang.reflect.Method;

public class Fila <X> implements Cloneable
{
    protected Object [] vetFila;
    protected int inicio;
    protected int fim;
    protected int quantidade;
    protected int tamanho;
    
    //Construtor para inicializar a fila;
    public Fila (int tam) throws Exception
    {
        if(tam <= 0)
            throws new Exception("Tamanho invalido.");
        
        vetFila = new Object[tam];
        this.inicio = 0;
        this.fim = 0;
        this.quantidade = 0;
        this.tamanho = tam;
    }
    
    public void push (X n) throws Exception
    {
        if(this.quantidade == this.tamanho)
            throw new Exception ("Fila cheia");
        
        if(this.fim > this.vetFila.length - 1)
            this.fim = 0;
            
        if(n instanceof Cloneable){
            Class classe = n.getClass();
            Class<?> [] parmsFormais = null;
            Method metodo = classe.getMethod("clone", parmsFormais);
            Object [] parmsReais = null;
            this.vetFila[this.fim] = (X)metodo.invoke(n,parmsReais);
            this.fim++;
            this.quantidade++; 
        }
        else{
            this.vetFila[this.fim] = n;
            this.fim++;
            this.quantidade++;   
        }
    }
    
    //POR FAVOR REVISAR L�GICA
    public X pop () throws Exception
    {
        if(this.quantidade == 0)
            throw new Exception("Fila vazia");
        
        if(this.inicio == this.quantidade)
            this.inicio = 0;
            
        this.quantidade--;
        return (X) this.vetFila[this.inicio++];
    }
    
    public boolean equals (Object obj)
    {
        if(this==obj)
            return true; 
            
        if(obj == null)
            return false;
            
        if(!obj instanceof Fila)
            return false;
        
        Fila aux = (Fila)obj;
        
        if(this.inicio != aux.inicio)
            return false;
        
        if(this.fim != aux.fim)
            return false;
            
        if(this.quantidade != aux.quantidade)
            return false;
            
        for(int i=0;i<this.ultimo;i++)
            if(!this.vetFila[i].equals(aux.vetFila[i]))
                return false;
                
        return true;
    }
    
    public String toString()
    {
        String s = null;
        
        for(int i =0; i<this.quantidade;i++)
            s = s + "[" + this.vetFila[i] + "]";
        
        return s;
    }
    
    public int hashCode()
    {
        int res = super.hashCode();
        
        res = res*13 + new Integer (this.inicio).hashCode();
        res = res*13 + new Integer (this.fim).hashCode();
        res = res*13 + new Integer (this.quantidade).hashCode();
        res = res*13 + new Integer (this.tamanho).hashCode();
                
        for(int i=0;i<this.quantidade;i++)
            res = res*13 + new Integer (this.vetFila[i]).hashCode();
        
        return res;
    }
    
    public Fila (Fila modelo) throws Excepetion
    {
        if(modelo==null)
            throw new Exception ("Modelo null");
            
        this.vetFila = new Object[modelo.vetFila.length];
        
        for(int i = 0;i<modelo.quantidade;i++)
        {
            if(modelo.vetFila[i] instanceof Cloneable)
                this.vetFila[i] =(X) modelo.vetFila[i].clone();
            else
                this.vetFila[i] = modelo.vetFila[i];
        }
        
        this.inicio = modelo.inicio;
        this.fim = modelo.fim;
        this.quantidade = modelo.quantidade;
        this.tamanho = modelo.tamanho;
    }
    
    public Object clone()
    {
        Fila f = null;
        
        try{
            f = new Fila(this);
        }
        catch(Exception erro)
        {}
        
        return f;
    }
}
