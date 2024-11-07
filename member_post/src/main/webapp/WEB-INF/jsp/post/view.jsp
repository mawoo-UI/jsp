<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../common/head.jsp"/>
</head>
<body>
    <div class="wrap" >
       <jsp:include page="../common/header.jsp"/>
       <main class="container">
            <div class="my-3 col-md-9 mx-auto">
                <label for="email" class="form-label mt-3"><i class="fa-solid fa-heading text-danger"></i><b> title</b></label>
                <input type="text" class="form-control" id="title" placeholder="title" name="title" value="${post.title}" disabled>

                <label for="content" class="form-label mt-3"><i class="fa-solid fa-align-left text-danger"></i><b> content</b></label>
                <textarea class="form-control" rows="20" id="content" placeholder="content" name="content" disabled>${post.content}</textarea>

                <label for="writer" class="form-label mt-3"><i class="fa-solid fa-user-pen text-danger"></i><b> writer</b></label>
                <input type="text" class="form-control" id="writer" placeholder="writer" name="writer" value="${post.writer}"  disabled>

                <label for="regdate" class="form-label mt-3"><i class="fa-regular fa-calendar text-danger"></i><b> Register Date</b></label>
                <input type="text" class="form-control" id="regdate" placeholder="regdate" name="regdate" value="${post.regdate}" disabled>

                <label for="updatedate" class="form-label mt-3"><i class="fa-regular fa-clock text-danger"></i><b> updated Date</b></label>
                <input type="text" class="form-control" id="writer" placeholder="updatedate" name="updatedate" value="${post.updatedate}" disabled>


                <div class="text-center my-5">
                    <a href="list" class="btn btn-primary">목록</a>
                </div>
            </div>
        </main>
  
        

</body>

</html>