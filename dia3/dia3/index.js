
const http = require('http');
const url = require('url');


//Servidor
const servidor = http.createServer((requisicao, resposta) => {
  //pegar url
const urlRecuperada = url.parse(requisicao.url, true);

const path = urlRecuperada.pathname;

console.log(requisicao.method + 'caminho requisitado:',path);

//console.log(requisicao);

if(requisicao.method == 'POST'){

//cabeçalho da respotsa da requisição http
resposta.writeHead(200, {'Content-Type': 'text/plain'});
//console.log(requisicao);
resposta.end('oi mundo');
}else{
resposta.writeHead(405);
resposta.end('pagina nao enontrada');
}

});


//porta do servidor 
const port = 8080

//inicia o servidor
servidor.listen(port, () => (
console.log('node rodando em http://localhost:'+port)
));