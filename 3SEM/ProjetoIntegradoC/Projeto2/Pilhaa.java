//isEmpty() 
//size()
//pop()
//push(valor)
//top()- n usar

public class Pilha <T> {
    
    
    
    protected Object []p;
    protected int topo;  
    
    //contrutor pilha
    public Pilha(int tamanho) throws Exception
    {
        this.p =  new Object[tamanho];
        this.topo = 0;
        
    }
    
    public boolean isEmpty()
    {
        if(this.topo==-1)
        {
            return true;
        }
        return false;
    }
    
    //metodo para desmontar a pilha 
    public Object pop()
    {
        if(isEmpty() == true)
        {
            return null;
        }
        Object ret = this.p[this.topo];//tem que tirar da pilha
        this.topo--;
        return ret;
    }
    
    //metodo para montar na pilha
    public Object push(Object valor)
    {
        if(this.topo == this.p.length-1)
        {
            System.out.println("Pilha cheia");
        }
        this.p[this.topo] = valor;
        Object ret = this.p[this.topo];
        this.topo++;
        if(this.topo == (10-1))
        {
            this.topo =0;
        }
        return ret;
        
    }
    
    
    //METODOS CANONICOS (OBRIGATORIOS)
    
    //...
    
    public boolean equals(Object obj)
    {
        if(this==obj)
        {
            return true;
        }
        if(obj == null)
        {
            return false;
        }
        if(!(obj instanceof Pilha))
        {
            return false;
        }
        Pilha pil = (Pilha) obj;
        if(this.p.length == pil.p.length)
        {
            return false;
        }
        for ( int i =0; i<= this.p.length; i++)
    {
        if(this.p[i] != pil.p[i])
        {
            return false;
        }
    }   
    return true;
    }
    
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Arrays.deepHashCode(this.p);
        hash = 83 * hash + this.topo;
        return hash;
    }

    public String toString() {
        return "Pilha{" + "p=" + p.length + '}';
    }

    

    

    
    
    

    //METODOS CANONICOS (OBRIGATORIOS AS VEZES)
    
    //.....
        public Object compareTo (Pilha outro)
    {
        return 0;
    }
}
