<%@ page import="com.sda.service.RegionServiceImpl"%>
<html>
<body>
	<% System.out.println("Entering region.jsp"); %>

	<%! RegionServiceImpl regionService = new RegionServiceImpl(); %>

	<% System.out.println("Calling regionService.getAllRegions()"); %>
	The first region is:
	<%= regionService.getAllRegions().get(0).getRegionName()%>


    <br/><br/>
	<form method="post" action="region.jsp">
		<input type="text" name="regionName"> <input type="submit"
			value="Save">
	</form>


	<% if(request.getParameter("regionName") != null) 
        regionService.saveRegion(request.getParameter("regionName"));
    %>

    <% System.out.println("Exiting region.jsp"); %>
</body>
</html>
