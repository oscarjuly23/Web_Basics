<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" version="5.0" encoding="UTF-8"/>
	<xsl:template match="/">
		<html>
			<body>
				<h1>Bienvenidos a <xsl:value-of select="company/name"/></h1>
				<strong>Detalles de contacto</strong>
				<ul>
					<li>Direccion: <xsl:value-of select="company/address"/></li>
					<li>Telefono: <xsl:value-of select="company/phone"/></li>
				</ul>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>