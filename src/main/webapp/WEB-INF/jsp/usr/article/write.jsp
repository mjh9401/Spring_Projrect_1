<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageTitle" value="게시글 쓰기"/>
<%@ include file="../common/header.jspf" %>

<section class="mt-5">
  <div class="container mx-auto px-3">
   <form action="../article/doWrite">
     <div class="table-box-type-1">
       <table>
         <colgroup>
           <col width="200px"/>
         </colgroup>
         <tbody>
           <tr>
             <th>제목</th>
             <td>
               <input required="required"  class="w-96" type="text" name="title" placeholder="제목을 적어주세요"/>
             </td>
           </tr>
           <tr>
             <th>내용</th>
             <td>
              <textarea required="required" name="body" class="w-full h-56" row="10" placeholder="내용을 적어주세요"></textarea>
             </td>
           </tr>
           <tr>
             <th>제출</th>
             <td>
               <input type="submit" value="제출" />
               <button type="button" onclick="history.back();">뒤로가기</button>   
             </td>
           </tr>
         </tbody>
       </table>
      </form>
    </div>
    
    <div>
      <button class="btn-text-link" type="button" onclick="history.back();">뒤로가기</button>
    </div>
</section>

<%@ include file="../common/footer.jspf"%>