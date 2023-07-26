const boardcode = location.pathname.substring(location.pathname.lastIndexOf("/") + 1);

const UpdateBtn = document.querySelector(".updateBtn");
	const title = document.querySelector("#title");
	const content = document.querySelector("#content");
let wirteUserCode = 0;

getBoardDetailData();

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
	title.value = board.title;
	content.value = board.content;
			  
}

//게시글 수정
UpdateBtn.onclick = () => {
	
	alert("게시글을 수정하시겠습니까.");
	
	$.ajax({
		async: false,
		type: "put",
		url: `/api/v1/board/update/${boardcode}`,
		contentType:"application/json",
		data:JSON.stringify(
			{ 
			 "title": title.value,
			 "content" : content.value
		}
		),
		dataType: "json",
		success: () => {
			alert("게시글 수정이 완료되었습니다.");
			location.href = "/board/list";
		},
		error: (error) => {
			console.log(error);
		}
	});
}

