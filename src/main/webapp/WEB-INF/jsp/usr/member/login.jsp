<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageTitle" value="로그인"/>
<%@ include file="../common/header.jspf" %>

<section class="mt-5">
  <div class="container mx-auto px-3">
   <form action="../member/dologin" method="post">
     <div class="table-box-type-2">
       <table>
         <colgroup>
           <col width="200"/>
         </colgroup>
         <tbody>
           <tr>
             <th>아이디</th>
             <td>
               <input required="required"  class="w-full h-full" type="text" name="loginId" placeholder="제목을 적어주세요"/>
             </td>
           </tr>
           <tr>
             <th>비밀번호</th>
             <td>
               <input type="password" class="w-full h-full" name="loginPw" placeholder="비밀번호를 입력해주세요"/>
             </td>
           </tr>
           <tr>
             <th colspan='2' class="bg-green-500">
               <input class="bg-green-500 text-white text-2xl w-full h-full cursor-pointer" type="submit" value="로그인" />
             </th>
           </tr>
         </tbody>
       </table>
      </form>
    </div>
</section>

<%@ include file="../common/footer.jspf"%>