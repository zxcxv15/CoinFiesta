
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
				getBoardList(response.data);
				console.log(response.data);
				
			}else{
				getBoardList(response.data);
			}
		},
		error: (error) => {
			console.log(error);
		}		
	});
}

function getBoardList(boardList) {
	const tbody = document.querySelector("tbody");
	let count = 1;
		tbody.innerHTML = "";
	
		boardList.forEach(board => {
			tbody.innerHTML += `
	 			<tbody>
	                <tr>
	                    <td>${count++}</td>
	                    <td class= "board-title"><a href="#">${board.title}</a></td>
	                    <td>${board.username}</td>
	                    <td>${board.createdate}</td>
	                </tr>
	            </tbody>
			`;			
		});
		
		setBoardClickEvent(boardList);
		console.log(boardList);
	}
	

// 제목 클릭하면 상세 페이지 이동
function setBoardClickEvent(boardList){
	const boardTitle = document.querySelectorAll(".board-title");
	
	
	for(let i = 0; i < boardTitle.length; i++){
		boardTitle[i].onclick = () =>{
			
			location.href = "/board/detail/" + boardList[i].boardcode;
			
		} 
	}
}

// 비회원 작성 막기
const writeBtn = document.querySelector(".btn-primary");
	writeBtn.onclick = () =>{
		if(getPrincipal() != null){
			location.href = "/board/write";		
		}else{
			alert("로그인 후 이용가능");
			location.href = "/auth/signin";	
		}
	} 