<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" version="5.0" encoding="UTF-8"/>
	<xsl:template match="/">
		<html>
			<body>
				<h2>Bookstore</h2>
				<h4>Libros de género Computer de precio inferior a 40€</h4>
				<table border="1">
					<tr bgcolor="#9acd32">
						<th>Title</th>
						<th>Author</th>
						<th>Description</th>
						<th>Price</th>
					</tr>
					<xsl:for-each select="catalog/book[genre='Computer']">
						<xsl:if test="price &lt; 40">
							<tr> 
								<td><xsl:value-of select="title"/></td>
								<td><xsl:value-of select="author"/></td>
								<td><xsl:value-of select="description"/></td>
								<td><xsl:value-of select="price"/></td>
							</tr>
						</xsl:if>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>