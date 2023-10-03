<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" version="5.0" encoding="UTF-8"/>
	<xsl:template match="/">
		<html>
			<body>
				<h2>Bookstore</h2>
				<table border="1">
					<tr bgcolor="#9acd32">
						<th>Title</th>
						<th>Author</th>
						<th>Price</th>
					</tr>
					<xsl:for-each select="catalog/book">
						<xsl:sort select="./price" data-type="number" order="descending"/>
						<tr> 
							<td><xsl:value-of select="title"/></td>
							<td><xsl:value-of select="author"/></td>
							<td><xsl:value-of select="price"/></td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>