<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" version="5.0" encoding="UTF-8"/>
	<xsl:template match="/">
		<html>
			<body>
				<h2>Bookstore</h2>
				<h4>Libros de género Computer </h4>
				<xsl:for-each select="catalog/book[genre='Computer']">
					<ul>
						<li> <xsl:value-of select="title"/> </li>
					</ul>
				</xsl:for-each>
				<h4>Libros de género Fantasy</h4>
				<xsl:for-each select="catalog/book[genre='Fantasy']">
					<ul>
						<li> <xsl:value-of select="title"/> </li>
					</ul>
				</xsl:for-each>
				<h4>Libros de género Romance</h4>
				<xsl:for-each select="catalog/book[genre='Romance']">
					<ul>
						<li> <xsl:value-of select="title"/> </li>
					</ul>
				</xsl:for-each>
				<h4>Libros de género Horror</h4>
				<xsl:for-each select="catalog/book[genre='Horror']">
					<ul>
						<li> <xsl:value-of select="title"/> </li>
					</ul>
				</xsl:for-each>
				<h4>Libros de género Science Fiction</h4>
				<xsl:for-each select="catalog/book[genre='Science Fiction']">
					<ul>
						<li> <xsl:value-of select="title"/> </li>
					</ul>
				</xsl:for-each>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>