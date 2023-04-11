
let page = 1;

getBoardData(page);

function getBoardData () {
		
       $.ajax({
		async: false,
		type: "get",
		url: "/api/v1/board/list/" + page,
		dataType: "json",
		success: (response) => {
			if(response.data[0] != null) {
				getBoardlist(response.data);
				
			}else{
				getBoardlist(list);
			}
		},
		error: (error) => {
			console.log(error);
		}		
	});
}

function getBoardlist(list) {
	const tbody = document.querySelector("tbody");
	
		tbody.innerHTML = "";
	
		list.forEach(board => {
			tbody.innerHTML += `
	 			<tbody>
	                <tr>
	                    <td>${board.boardcode}</td>
	                    <td class= "board-title"><a href="#">${board.title}</a></td>
	                    <td>${board.createdate}</td>
	                </tr>
	            </tbody>
			`;			
		});
		setBoardClickEvent(list);
	}
	

	
function setBoardClickEvent(boardList){
	const boardTitle = document.querySelectorAll(".board-title");
	
	
	for(let i = 0; i < boardTitle.length; i++){
		boardTitle[i].onclick = () =>{
			
			location.href = "/board/detail/" + boardList[i].boardcode;
			
		} 
	}
}



