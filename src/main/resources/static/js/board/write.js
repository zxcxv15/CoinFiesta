const btnPrimary = document.querySelector(".btn-primary");
const title = document.querySelector("#title");
const content = document.querySelector("#content");

btnPrimary.onclick = () => {
	 $.ajax({
      async: false,
      type: "post",
      url: "/api/v1/board/write",
      contentType: "application/json",
      data: JSON.stringify({
				 title: title.value,
				 content: content.value
				})
	  ,
      dataType: "json",
      success: (response) => {
         if(response.data){
         alert("게시판 작성 완료.");  
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