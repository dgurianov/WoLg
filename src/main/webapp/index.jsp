<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WoLg</title>
        <style type="text/css">

* { margin: 0; padding: 0; }

html { height: 100%; font-size: 62.5% }

body { height: 100%; background-color: #FFFFFF; font: 1.2em Verdana, Arial, Helvetica, sans-serif; }


/* ==================== Form style sheet ==================== */

table.form { margin: 25px 0 0 29px; border-collapse: collapse; }

table.form th, table.form td { padding: 4px 5px; text-align: left; font-weight: normal; }

table.form label { font-family: Verdana, Arial, Helvetica, sans-serif; color: #181818; margin-right: 12px; }
table.form td span { font-size: 0.9em; color: #181818; margin-left: 8px; }
table.form td samp { font: 1em Verdana, Arial, Helvetica, sans-serif; color: #000000; }

table.form input { width: 340px; }
table.form input.answer { width: 53px; }
table.form textarea { width: 400px; height: 160px; }

table.form input.inp-text, table.form input.answer, table.form textarea
{ border: 1px solid #909090; padding: 2px; }

table.form th.message-up { vertical-align: top !important; }

table.form label.invisible { visibility: hidden; }

table.form td.submit-button-right { text-align: right !important; }
table.form input.submit-text { font: 1.4em Georgia, "Times New Roman", Times, serif; letter-spacing: 1px; width: auto; }

table.form label.email { border-bottom: 1px dotted #000000; }
/*  ================================================*/
table.form1 { margin: 25px 0 0 29px; border-collapse: collapse; }

table.form1 th, table.form td { padding: 4px 5px; text-align: left; font-weight: normal; }

table.form1 label { font-family: Verdana, Arial, Helvetica, sans-serif; color: #181818; margin-right: 12px; }
table.form1 td span { font-size: 0.9em; color: #181818; margin-left: 8px; }
table.form1 td samp { font: 1em Verdana, Arial, Helvetica, sans-serif; color: #000000; }

table.form1 input { width: 340px; }
table.form1 input.answer { width: 53px; }
table.form1 textarea { width: 400px; height: 17px; }

table.form1 input.inp-text, table.form1 input.answer, table.form1 textarea
{ border: 1px solid #909090; padding: 2px; }

table.form1 th.message-up { vertical-align: top !important; }

table.form1 label.invisible { visibility: hidden; }

table.form1 td.submit-button-right { text-align: right !important; }
table.form1 input.submit-text { font: 1.4em Georgia, "Times New Roman", Times, serif; letter-spacing: 1px; width: auto; }

table.form1 label.email { border-bottom: 1px dotted #000000; }


table.actions td.border-right {border-right:  1px solid;}
table.actions td.border-left {border-right:  1px solid;}
/* ==================== Form style sheet END ==================== */

</style>
    </head>
    <body>
        <table class="actions">
            <tr>
            <td width="30" class="border-right">
                <b>Num        </b>
            
          </td>
          <td width="150" class="border-right">
              <b>&nbsp;Time start</b>
          </td>
          <td width="150" class="border-right">
             <b>&nbsp;Time end</b>
          </td>
          <td width="150" class="border-right">
             <b>&nbsp;Time delta</b>
          </td>
          <td >
             <b>Task description</b>
          </td>
        </tr>
        <jsp:useBean id="inMemoryStorage" type="fun.gud.wolg.stub.InMemoryStorage" scope="application"/>
        <jsp:useBean id="DateOperations" type="fun.gud.wolg.util.DateOperations" scope="application"/>
    <c:forEach var="aItem" items="${inMemoryStorage.getAllRecordsAsList()}">
        <tr>
            <td width="30" class="border-right">
                <b>
              <c:choose>
                    <c:when test="${aItem.id < 10}" >
                        <c:out value="0${aItem.id}" />
                    </c:when>
                  <c:otherwise>
                       <c:out value="${aItem.id}" />
                  </c:otherwise>
              </c:choose>
                
            </b>
          </td>
          <td width="150" class="border-right">
             <c:out value="${aItem.startTime}" /> 
          </td>
          <td width="150" class="border-right">
             <c:out value="${aItem.endTime}" /> 
             
          </td>
          <c:choose>
           <c:when test="${aItem.endTime eq 'Pending...'}">
            <td width="150" class="border-right">
                <c:out value="Pending..." /> 
            </td>
            
           </c:when>
            <c:otherwise>
            <td width="150" class="border-right">
                <c:out value="${aItem.deltaTime}" /> 
            </td>
            </c:otherwise> 
          </c:choose> 
          <td >
             <c:out value="${aItem.actionDone}" /> 
          </td>
        </tr>
      </c:forEach>
    </table>
 



<form action="/wolg/addactivity" method="post">
    <table class="form">

        <tr>
            <th class="message-up"><label for="message"><strong>Activity:</strong></label></th>
            <td>
                <textarea name="message" id="message" cols="30" rows="5"></textarea>
            </td>
        </tr>
        <c:choose>
            <c:when test="${!empty inMemoryStorage.last && inMemoryStorage.getLast().endTime=='Pending...'}">
                <tr>
                    <td class="submit-button-right" colspan="2">
                        <input class="submit-text" type="submit" value="Finish activity" title="Send your message" />
                    </td>
                </tr> 
                <c:set var="isPending" value="true" scope="application" />
            </c:when>
            <c:otherwise>
                <tr>
                    <td class="submit-button-right" colspan="2">
                        <input class="submit-text" type="submit" value="Add Activity" title="Send your message" />
                    </td>
                </tr>
                <c:set var="isPending" value="false" scope="application" />
            </c:otherwise>
        </c:choose>
                
    </table>
</form>
<form action="/wolg/savetofile" method="post">
    <table class="form1" >
        <jsp:useBean id="configuration" type="fun.gud.wolg.configuration.Config" scope="application"/>
        <tr>
            <th class="message-up"><label for="message"><strong>To file:&nbsp;&nbsp;&nbsp;</strong></label></th>
            <td>
                <textarea name="outputFile" id="outputFile" cols="30" rows="1" >${configuration.config.getProperty('file.name.to.save')}_${DateOperations.day}.txt</textarea>
            </td>
        </tr>
        <tr>
                    <td class="submit-button-right" colspan="2">
                        <input class="submit-text" type="submit" value="Save to file" title="Send your message" />
                    </td>
        </tr>
    </table>
</form>
</body>
</html>