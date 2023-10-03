<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" version="1.0" encoding="UTF-8"/>
	<xsl:template match="/">		
		<xsl:for-each select="catalog/book">
			<book>
				<title><xsl:value-of select="title"/></title>
				<genre><xsl:value-of select="genre"/></genre>
				<price><xsl:value-of select="price"/></price>
				<xsl:choose>
					<xsl:when test = "genre='Computer'">
						<description><xsl:value-of select="description"/></description>
					</xsl:when>
						<xsl:otherwise>
							<author><xsl:value-of select="author"/></author>
						</xsl:otherwise>
				</xsl:choose>
			</book>
		</xsl:for-each>
			
	</xsl:template>
</xsl:stylesheet>