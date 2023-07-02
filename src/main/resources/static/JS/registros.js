
console.log(enderecoIp);
console.log(idUsuario);

createBtnGetOrdem();

function btnAno(listaRegistros) {
	
	let result = listaRegistros.map(a => a.data);

    const firstDatePerYear = result
                                .sort((a, b) => new Date(a) - new Date(b))
                                .reduce((acc, curr) => {
                                    const year = new Date(curr).getFullYear();
                                    if (!acc[year]) acc[year] = curr;
                                    return acc;
                                }, {});

    console.log(firstDatePerYear);
    
    let anos = Object.keys(firstDatePerYear);

    let count = Object.keys(firstDatePerYear).length;
    
	console.log(count);
	console.log(anos);
    
    for(var i=0; i<count; i++){
        let buttonId = i;
        let btn = document.createElement("BUTTON");
        
        btn.id = 'btn' + anos[buttonId];
        btn.innerHTML = anos[buttonId];
        btn.setAttribute("value", anos[buttonId]);
        btn.setAttribute("text", anos[buttonId]);
        document.getElementById("anosRegistros").appendChild(btn);
    }


}

function popularRegistros(listaRegistros, ano){

const start =  new Date(ano,0,1);
const end = new Date(ano,11,31);

let listaFiltrada = listaRegistros.filter(item => {
    let date = new Date(item.data).getTime();
    return date >= start && date <= end;
});

console.log(`lista do ano ${ano}`);
console.log(listaFiltrada);
var tableRow = document.createElement("table");

document.getElementById("registros").appendChild(tableRow);

for(let i = 0; i < listaFiltrada.length; i = i + 1 )  {

		
 //   let tableRow = document.getElementById("tabelaAtvs");
    let row = document.createElement("tr");
    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td"); 
    cell1.innerHTML = listaFiltrada[i].descricao; 
    cell2.innerHTML = dataFormatada(listaFiltrada[i].data);
    cell3.innerHTML = listaFiltrada[i].tipo;
    cell4.innerHTML = listaFiltrada[i].valor;
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    tableRow.appendChild(row);
	
    
    };



}

function dataFormatada(data){
    var date = new Date(data);
    dia  = date.getDate().toString().padStart(2, '0');
    mes  = (date.getMonth()+1).toString().padStart(2, '0');
    ano  = date.getFullYear();
return dia+"/"+mes+"/"+ano;
}



function createBtnGetOrdem() {


$.ajax({
    url: "http://"+enderecoIp+":8080/vrecords/MeusRegistros?userId=" + idUsuario, 
    type: "GET",
    success: function (result) {

        console.log(result);
        btnAno(result);
        popularRegistros(result, 2023);
        
        
	},
	error: function (result, status) {
        console.log(result);
        console.log(status);
	    console.log("Nenhum registro encontrado.");
	    }
	});
	

	
	}