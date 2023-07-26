const boardcode = location.pathname.substring(location.pathname.lastIndexOf("/") + 1);

const listBarckBtn = document.querySelector(".btn-listBarck");
const DeleteBtn = document.querySelector(".deleteBtn");
const UpdateBtn = document.querySelector(".updateBtn");
const CommentWriteBtn = document.querySelector(".commentWriteBtn");


let wirteUserCode = 0;

getBoardDetailData();
/*
 1. board = response.date 같은거다.
 2. ajax에서 해당 컨트롤러에 넘겨주고 return이 CMRespDto<code,message,date>이다. 
	  이 떄 data가 CMRespospDto의 T data에 들어가고 T에는 모든 자료형이 들어올 수 있기 떄문에 readBoardRespDto가 들어오게 된다.
	  그래서 readBoardRespDto 안에 있는 데이터들을 참조해서 사용할 수 있다.
*/
// 데이터 불러오기
function getBoardDetailData() {
	$.ajax({
		async: false,
		type: "get",
		url: `/api/v1/board/detail/${boardcode}`,
		dataType: "json",
		success: (response) => {
			wirteUserCode = response.data.usercode;
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
			            <th>작성자</th>
			            <td>${board.username}</td>
			        </tr>
			        <tr>
			            <th>내용</th>
			            <td>${board.content}</td>
			        </tr>
			 </tbody>
			  
		`;
}

//게시글 삭제
DeleteBtn.onclick = () => {
	if (getPrincipal() != null && wirteUserCode == getPrincipal().user_code) {
		if(confirm("게시글을 삭제하시겠습니까.")){
			$.ajax({
				async: false,
				type: "delete",
				url: `/api/v1/board/delete/${boardcode}`,
				dataType: "json",
				success: () => {
					alert("게시글 삭제가 완료되었습니다.");
					location.href = "/board/list";
				},
				error: (error) => {
					console.log(error);
				}
			});		
		}
	} else {
		if(getPrincipal() == null){
			alert("로그아웃 됬습니다.");
			location.href = "/auth/signin";
		}else{
			alert("타인의 게시글은 삭제할 수 없습니다.");
		}
	}

}

//게시글 댓글 작성
CommentWriteBtn.onclick = () => {
	const commentContent = document.querySelector("#comment-content");
	 $.ajax({
      async: false,
      type: "post",
      contentType: "application/json",
      url: `/api/v1/board/commentWrite/${boardcode}`,
	  data: JSON.stringify({
		  "usercode" : usercode,
		  "content" : commentContent.value
	  }),
	  dataType: "json",
      success: (response) => {
         if(response.data){
         alert("게시판 작성 완료하였습니다.");  
         location.replace("/board/list");
       
         }
      },
      error:(error) => {
         if(error.status == 400){
            alert(JSON.stringify(error.responseJSON.data))
  
         }
         console.log("요청실패");
         console.log(error);         
      }
   });
}

listBarckBtn.onclick = () => {
	location.href = "/board/list";
}

UpdateBtn.onclick = () => {
	if (wirteUserCode == getPrincipal().user_code) {
		
		location.href = `/board/update/${boardcode}`;
	}else{
		alert("타인의 게시글은 수정할 수 없습니다.");
	}
}
