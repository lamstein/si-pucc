var reader, arrLabirinto, pilha;

arrLabirinto = [];

pilha = {
    'topo' : 0,
    'arrPos' : [] // ARRAY DE OBJETOS {'l' : '', 'c' : ''}
};

entradas = {
    'topo' : 0,
    'arrPos' : [] // ARRAY DE OBJETOS {'l' : '', 'c' : ''}
};


//
//
//
//
function push(l,c, p) {
    p.arrPos[p.topo] = {'l' : l,'c' : c};
    p.topo++;
}


//
//
//
//
function pop(p) {
    if (p.topo-1 < 0){
        p.topo = 0;
        
        return -1;
    }
                        
    p.arrPos.splice(p.topo, 1);
    p.topo--;
     
    return p.arrPos[p.topo]; 
}


//
//
//
//
function verificarFileAPI() {
    if (window.File && window.FileReader && window.FileList && window.Blob) {
        reader = new FileReader();
        return true;
    } else {
        alert('Seu navegador não possuí suporte para leitura de arquivo no navegador.');
        return false;
    }
}


//
//
//
//
function lerArquivo(filePath) {
    var output, l, c, i;
    output = "";
    
    l = 0;
    
    c = 0;
        
    if(filePath.files && filePath.files[0]) {
        reader.onload = function (e) {
            output = e.target.result;
            arrLabirinto = [];
            
            for(i = 0; i < output.length; i++)
            {
                if (typeof arrLabirinto[l] == 'undefined')
                    arrLabirinto[l] = [];

                if (output[i] != '\r' && output[i] != '\n') {
                    arrLabirinto[l][c] = output[i];
                    c++;
                } else if (output[i] == '\r') {
                    c = 0;
                    l++;
                }
            }

            escreveLabirinto();
        };
        reader.readAsText(filePath.files[0]);
    }
    
    return true;
}


//
//
//
//
function escreveLabirinto() {
    var l, c, tr, td;
    
    l = 0;
    
    c = 0;
    
    tr = '';
    
    td ='';

    for (l = 0; l < arrLabirinto.length; l++) {
        for (c = 0; c < arrLabirinto[0].length; c++) {
            td += '<td class="' + arrLabirinto[l][c] + '" id="field-' + l + '-' + c + '">' + arrLabirinto[l][c] + '</td>';
        }
        tr += '<tr>' + td + '</tr>';
        td = '';
    }

    document.getElementById('main').innerHTML = '<table>'+tr+'</table>';
    
    encontraEntrada();
}


//
//
//
//
function encontraEntrada() {
    var l,c, i;    
    
    for (l = 0; l < arrLabirinto.length; l++) {
        for (c = 0; c < arrLabirinto[0].length; c++) {
            if (arrLabirinto[l][c] == "E") {
                push(l,c,entradas);
            }
        }
    }
    
    if (entradas.length == 0) {
        alert("O Labirinto não possuí entradas.");
    }
    
    resolveLabirinto(pop(entradas));
}


//
//
//
//
function resolveLabirinto(pos) {
    if (pos == -2) {
        alert("Saída Encontrada!");
        return false;   
    }
    
    if (pos == -1) { 
        console.log('proxima saida');
        pos = pop(entradas);
    }
    setTimeout(function () {                            
        return resolveLabirinto(validaCaminho(pos));   
    }, 32);
}


//
//
//
//
function validaCaminho(pos) {
    var pPos;
    
    if (typeof arrLabirinto[pos.l+1] != 'undefined') {
        if (arrLabirinto[pos.l+1][pos.c] == "P") {
            movePos(pos.l+1,pos.c);
            arrLabirinto[pos.l+1][pos.c] = "1";
            push(pos.l, pos.c, pilha);
            pos.l++;
            return pos;
        } else if (arrLabirinto[pos.l+1][pos.c] == "S") {
            return -2;
        }    
    }
    
    if (typeof arrLabirinto[pos.l-1] != 'undefined') {
        if (arrLabirinto[pos.l-1][pos.c] == "P") {
            movePos(pos.l-1,pos.c);
            arrLabirinto[pos.l-1][pos.c] = "1";
            push(pos.l, pos.c, pilha);
            pos.l--;
            return pos;
        } else if (arrLabirinto[pos.l-1][pos.c] == "S") {
            return -2;
        }
    }
    
    if (typeof arrLabirinto[pos.l][pos.c+1] != 'undefined') {
        if (arrLabirinto[pos.l][pos.c+1] == "P") {
            movePos(pos.l,pos.c+1);
            arrLabirinto[pos.l][pos.c+1] = "1";
            push(pos.l, pos.c, pilha);
            pos.c++;
            return pos;
        } else if (arrLabirinto[pos.l][pos.c+1] == "S") {
            return -2;
        }
    }
    
    if (typeof arrLabirinto[pos.l][pos.c-1] != 'undefined') {
        if (arrLabirinto[pos.l][pos.c-1] == "P") {
            movePos(pos.l,pos.c-1);
            arrLabirinto[pos.l][pos.c-1] = "1";
            push(pos.l, pos.c, pilha);
            pos.c--;
            return pos;
        } else if (arrLabirinto[pos.l][pos.c-1] == "S") {
            return -2;
        }
    }
                    
    pPos = pop(pilha);
    
    if (pPos != -1) 
        movePos(pPos.l,pPos.c);                
    return pPos;            
}


//
//
//
//
function movePos(l,c) {
    var el, ident, oldEl;
    
    console.log(l,c);
    
    ident = 'field-' + l + '-' + c;
    el = document.getElementById(ident);           
    
    oldEl = document.querySelector('.here');
    
    if (oldEl){                  
        oldEl.className = oldEl.className.replace(' here', '');
    }
                     
    if (el.className.indexOf('here') > -1) {
        el.className = el.className.replace(' here', '');
    } else {        
        el.className = el.className += ' here';
    }        
}