<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
    <script language="javascript">
    	//设置选择的厂家名称
    	function setFactoryName(val){
    		document.getElementById("factoryName").value = val;
    	}
    </script>
</head>
<body>
<form method="post">
	<input type="hidden" name="contractId" value="${contractId}">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('insert.action','_self');this.blur();">确定</a></li>
<li id="back"><a href="${ctx}/cargo/contract/list.action">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		新增货物信息
    </div> 
    </div>
    </div>
<div>
 
    <div>
		<table class="commonTable" cellspacing="1">
		    <tr>
	            <td class="columnTitle_mustbe">排序号：</td>
	            <td class="tableContent"><input type="text" name="orderNo" value=""/></td>
	        </tr>		
		    <tr>
	            <td class="columnTitle_mustbe">生产厂家：</td>
	            <td class="tableContent">
	            	<select name="factoryId" onchange="setFactoryName(this.options[this.selectedIndex].text);">
	            		<option value="">--请选择--</option>
	            		<c:forEach items="${factoryList}" var="f">
	            			<option value="${f.id}">${f.factoryName}</option>
	            		</c:forEach>
	            	</select>
	            	<input type="hidden" id="factoryName" name="factoryName" value=""/>
	            </td>
	            <td class="columnTitle_mustbe">货号：</td>
	            <td class="tableContent"><input type="text" name="productNo" value=""/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle_mustbe">图片：</td>
	            <td class="tableContent"><input type="text" name="productImage" value=""/></td>
	            <td class="columnTitle_mustbe">数量：</td>
	            <td class="tableContent"><input type="text" name="cnumber" value=""/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">装率：</td>
	            <td class="tableContent"><input type="text" name="loadingRate" value=""/></td>
	            <td class="columnTitle_mustbe">箱数：</td>
	            <td class="tableContent"><input type="text" name="boxNum" value=""/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">包装单位：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="packingUnit" value="PCS"  class="input">只
	            	<input type="radio" name="packingUnit" value="SETS" class="input">套
	            </td>
	            <td class="columnTitle_mustbe">单价：</td>
	            <td class="tableContent"><input type="text" name="price" value=""/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle">货物描述：</td>
	            <td class="tableContent"><textarea name="productDesc" style="width:100%;height:120px;"></textarea></td>
	            <td class="columnTitle">附件：</td>
	            <td class="tableContent"><textarea name="exts" style="width:100%;height:120px;"></textarea></td>

	        </tr>

		</table>
	</div>
</div>
 
<!-- 页面主体部分（列表等） -->  
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
   货物信息列表
  </div> 
  </div>
  </div>
  
<div>
	

<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">生产厂家</td>
		<td class="tableHeader">货号</td>
		<td class="tableHeader">数量</td>
		<td class="tableHeader">装率</td>
		<td class="tableHeader">箱数</td>
		<td class="tableHeader">单价</td>
		<td class="tableHeader">包装单位</td>
		<td class="tableHeader">总金额</td>
		<td class="tableHeader">操作</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${dataList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.factoryName}</td>
		<td>${o.productNo}</td>
		<td>${o.cnumber}</td>
		<td>${o.loadingRate}</td>
		<td>${o.boxNum}</td>
		<td>${o.price}</td>
		<td>${o.packingUnit}</td>
		<td>${o.amount}</td>
		<td>
			<a href="toupdate.action?id=${o.id}">[修改]</a>
			<a href="deleteById.action?id=${o.id}&contractId=${contractId}">[删除]</a>
			<a href="${ctx}/cargo/extcproduct/tocreate.action?contractProductId=${o.id}">[附件]</a>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>

</form>
</body>
</html>

