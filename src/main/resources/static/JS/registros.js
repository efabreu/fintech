
console.log(enderecoIp);
console.log(idUsuario);

createBtnGetOrdem();
//calculadora();
//startFloatingButton();
collapsibleNew();

function collapsibleNew() {
	var coll = document.getElementsByClassName("collapsible");
	var i;

	for (i = 0; i < coll.length; i++) {
		coll[i].addEventListener("click", function () {
			this.classList.toggle("active");
			var content = this.nextElementSibling;
			if (content.style.display === "block") {
				content.style.display = "none";
			} else {
				content.style.display = "block";
			}
		});
	}
}

function btnAno(listaRegistros) {

	let container = document.getElementById("anosRegistros");
	clearBox("anosRegistros");
	
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
        btn.className = "btn btn-outline-success";
        
        btn.onclick = function() {popularRegistros(listaRegistros, anos[buttonId]);}
        btn.setAttribute("value", anos[buttonId]);
        btn.setAttribute("text", anos[buttonId]);
        container.appendChild(btn);
    }


}

function popularRegistros(listaRegistros, ano){

	clearBox("registros");

	const start =  new Date(ano,0,1);
	const end = new Date(ano,11,31);
	
	const tit = document.getElementById("tittle");
    tit.innerHTML = `Registros de entradas e saídas - ${ano}`;
	
	let listaFiltrada = listaRegistros.filter(item => {
	    let date = new Date(item.data).getTime();
	    return date >= start && date <= end;
	});

	let result = listaFiltrada.map(a => a.data);
	const firstDatePerMonth = result
                                .sort((a, b) => new Date(a) - new Date(b))
                                .reduce((acc, curr) => {
                                    const month = new Date(curr).getMonth();
                                    if (!acc[month]) acc[month] = curr;
                                    return acc;
                                }, {});
	let months = Object.keys(firstDatePerMonth);

    let countMonths = Object.keys(firstDatePerMonth).length;
	
	console.log(`lista do ano ${ano}`);
	console.log(listaFiltrada);
	//var tableRow = document.createElement("table");
	
	
	var month = "";


	for(let i = 0; i < countMonths; i++){

		const start =  new Date(ano,+months[i],1);
		const end = new Date(ano,+months[i]+1,0);

		let listaMes = listaFiltrada.filter(item => {
			let date = new Date(item.data).getTime();
			return date >= start && date <= end;
		});

		let header = document.createElement("h2");
		header.innerHTML = mesPorExtenso(months[i]);
		document.getElementById("registros").appendChild(header);
		var tableRow = document.createElement("table");
		let tittle = document.createElement("tr");
		let t1 = document.createElement("td");
		let t2 = document.createElement("td");
		let t3 = document.createElement("td");
		let t4 = document.createElement("td");
		t1.innerHTML = "Descrição";
		t2.innerHTML = "Data";
		t3.innerHTML = "Tipo";
		t4.innerHTML = "Valor";
		tittle.appendChild(t1);
		tittle.appendChild(t2);
		tittle.appendChild(t3);
		tittle.appendChild(t4);
		tableRow.appendChild(tittle);

		tableRow.className = "tabela";

		for(let i = 0; i < listaMes.length; i = i + 1 )  {
	
			let row = document.createElement("tr");
			row.className = "linha";
			let cell1 = document.createElement("td");
			let cell2 = document.createElement("td");
			let cell3 = document.createElement("td");
			let cell4 = document.createElement("td"); 
			cell1.innerHTML = listaMes[i].descricao; 
			cell2.innerHTML = dataFormatada(listaMes[i].data);
			if(listaMes[i].tipo){
				cell3.innerHTML = "Entrada";
				cell4.innerHTML = listaMes[i].valor;
			}else{
				cell3.innerHTML = "Saída";
				cell4.innerHTML = listaMes[i].valor*-1;
			}
			
			row.appendChild(cell1);
			row.appendChild(cell2);
			row.appendChild(cell3);
			row.appendChild(cell4);
			tableRow.appendChild(row);
			//document.getElementById("registros").appendChild(tableRow);
			
	
		};
		document.getElementById("registros").appendChild(tableRow);


	}


}

function mesPorExtenso (data){
	// if (typeof data == "string");
	// const date = new Date(data);
	// mes  = (date.getMonth());
	// let monthNumber = date.getMonth;
	let monthNumber = +data;
	let monthString;
	switch (monthNumber) {
		case 0:
			monthString = "Janeiro";
			break;

		case 1:
			monthString = "Fevereiro";
			break;

		case 2:
			monthString = "Março";
			break;

		case 3:
			monthString = "Abril";
			break;

		case 4:
			monthString = "Maio";
			break;

		case 5:
			monthString = "Junho";
			break;

		case 6:
			monthString = "Julho";
			break;

		case 7:
			monthString = "Agosto";
			break;

		case 8:
			monthString = "Setembro";
			break;
			
		case 9:
			monthString = "Outubro";
			break;
			
		case 10:
			monthString = "Novembro";
			break;

		default:
			monthString = "Dezembro";
			break;
	}
	return monthString;
}

function dataFormatada(data){
    let date = new Date(data);
    dia  = date.getDate().toString().padStart(2, '0');
    mes  = (date.getMonth()+1).toString().padStart(2, '0');
    ano  = date.getFullYear();
return dia+"/"+mes+"/"+ano;
}

function createBtnGetOrdem() {

	const dataHoje = new Date;
	const anoAtual = dataHoje.getFullYear();

	$.ajax({
		url: "http://"+enderecoIp+":8080/vrecords/MeusRegistros?userId=" + idUsuario, 
		type: "GET",
		success: function (result) {

			const listaOrdenada = result.sort(function(a,b){
										  // Turn your strings into dates, and then subtract them
										  // to get a value that is either negative, positive, or zero.
										  return new Date(a.data) - new Date(b.data);
										});
			
			console.log(listaOrdenada);
			btnAno(listaOrdenada);
			popularRegistros(listaOrdenada, anoAtual);
			
			
		},
		error: function (result, status) {
			console.log(result);
			console.log(status);
			console.log("Nenhum registro encontrado.");
			}
		});
	

	
	}

function clearBox(elementID){
	document.getElementById(elementID).innerHTML = "";
}

function calculadora(){
	const input = document.getElementById("input");
	const tmp = document.getElementById("tmp");

	const empty = (element) => {
		element.innerText = "";
	};

	document.getElementById("all-clear").addEventListener("click", () => {
		empty(input);
		empty(tmp);
	});

	document.getElementById("clear").addEventListener("click", () => {
		empty(input);
	});

	document.querySelectorAll(".number").forEach((element) => {
		element.addEventListener("click", () => {
			if (input.innerText.length > 19)
				return alert("Máximo de caracteres atingido!");

			input.innerText += element.innerText;
		});
	});

	document.getElementById("dot").addEventListener("click", () => {
		if (input.innerText.includes(".")) return;

		input.innerText += ".";
	});

	document.getElementById("sign").addEventListener("click", () => {
		if (input.innerText.startsWith("-")) {
			input.innerText = input.innerText.slice(1);
		} else {
			input.innerText = `-${input.innerText}`;
		}
	});

	document.querySelectorAll(".amt").forEach((element) => {
		element.addEventListener("click", () => {
			if (input.innerText) {
				if (tmp.innerText) {
					tmp.innerText = `${tmp.innerText} ${input.innerText} ${element.innerText}`;
				} else {
					tmp.innerText = `${input.innerText} ${element.innerText}`;
				}
			} else if (tmp.innerText.slice(-1).match(/-|\+|\*|\//)) {
				let string = tmp.innerText.slice(0, -1);
				string += element.innerText;

				tmp.innerText = string;
			}

			empty(input);
		});
	});

	document.getElementById("result").addEventListener("click", () => {
		if (input.innerText) {
			input.innerText = eval(tmp.innerText + input.innerText);
			empty(tmp);
		}
	});
}

function startFloatingButton(){

	var floatingButtonContainer = document.querySelector('.floating-button-div');
	var scrollY = window.scrollY;

	window.addEventListener('scroll', function() {
										scrollY = window.scrollY;
										floatingButtonContainer.style.top = scrollY + window.innerHeight - 150 + 'px';
										});

}