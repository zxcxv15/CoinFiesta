const boardcode = location.pathname.substring(location.pathname.lastIndexOf("/") + 1);

getBoardDetailData();


function getBoardDetailData () {
		
       $.ajax({
		async: false,
		type: "get",
		url: `/api/v1/board/detail/${boardcode}`,
		dataType: "json",
		success: (response) => {
			getBoardDetail(response.data); 
		},
		error: (error) => {
			console.log(error);
		}		
	});
}
	
function getBoardDetail(board) {
	const tbody = document.querySelector("tbody");
	
		tbody.innerHTML = "";
	
		tbody.innerHTML += `
		<tbody>
		        <tr>
		            <th style="width: 20%">제목</th>
		            <td>${board.title}</td>
		        </tr>
		        <tr>
		            <th>작성일</th>
		            <td>${board.createdate}</td>
		        </tr>
		        <tr>
		            <th>내용</th>
		            <td>${board.content}</td>
		        </tr>
		        </tbody>
		`;
	
}
