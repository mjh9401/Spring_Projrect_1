<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageTitle" value="게시글"/>
<%@ include file="../common/header.jspf" %>
 <div>
   <table class="table table-fixed w-full">
     <thead>
       <tr>
         <th>번호</th>
         <th>작성날짜</th>
         <th>수정날짜</th>
         <th>제목</th>
       </tr>
     </thead>
     <tbody>
       <c:forEach var="article" items="${articles}">
         <tr>
           <th>${article.id}</th>
           <th>${article.regDate}</th>
           <th>${article.updateDate}</th>
           <th>
             <a href="../article/detail?id=${article.id}">
                ${article.title}
             </a> 
           </th>
         </tr>
       </c:forEach>
     </tbody>
   </talbe>
 </div>
<%@ include file="../common/footer.jspf" %>
