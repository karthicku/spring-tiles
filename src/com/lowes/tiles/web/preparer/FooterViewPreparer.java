/* ***************************************************************************
    Copyright (C) Lowe's Companies, Inc.  All rights reserved.
    This file is for internal use only at Lowe's Companies, Inc., and should
    not be modified without permission from the Application Architecture team.
   ***************************************************************************/

package com.lowes.tiles.web.preparer;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class takes the page heading from the request context and moves it to the
 * attribute context so the pageHeading.jsp fragment can get to it for rendering.
 * @author  $Author: mcoffey $
 * @version $Revision: 1.1 $
 */
public class FooterViewPreparer implements ViewPreparer {
	
	private static Logger LogIt = LoggerFactory.getLogger(FooterViewPreparer.class);
	private static final String VERSION = "version";
	private static final String COPYRIGHT = "copyright";
	private static final String DEFAULT_COPYRIGHT = "2013";
	private static final String EMPTY_STRING = "";
	private Properties properties;

	/**
	 * Constructor for FooterViewPreparer.
	 * @param properties Properties
	 */
	public FooterViewPreparer(Properties properties) {

		this.properties = properties;
	}

	/**
	 * Method execute.
	 * @param requestContext TilesRequestContext
	 * @param attributeContext AttributeContext
	 * @throws PreparerException
	 * @see org.apache.tiles.preparer.ViewPreparer#execute(TilesRequestContext, AttributeContext)
	 */
	public void execute(TilesRequestContext requestContext, AttributeContext attributeContext)
		throws PreparerException {

		LogIt.debug("Inside Footer View Preparer");
		String copyright = EMPTY_STRING;
		if (properties == null) {
			LogIt.warn("No version was passed in");
			attributeContext.putAttribute(VERSION, new Attribute(EMPTY_STRING));
		}
		else {
			String version = properties.getProperty(VERSION, EMPTY_STRING);
			LogIt.info("version: " + version);
			attributeContext.putAttribute(VERSION, new Attribute(version));
			
			copyright = properties.getProperty(COPYRIGHT, EMPTY_STRING);
			LogIt.info("version.properties copyright: " + copyright);
		}
		if (StringUtils.isBlank(copyright)) {
			URL url = FooterViewPreparer.class.getResource("/WEB-INF/version.properties");
			if (url != null) {
				String path = url.getFile();
				File file = new File(path);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
				copyright = sdf.format(file.lastModified());
				LogIt.info("version.properties.lastModified copyright: " + copyright);
			}
			else {
				copyright = DEFAULT_COPYRIGHT;
				LogIt.warn("Default copyright used: " + copyright);
			}
		}
		attributeContext.putAttribute(COPYRIGHT, new Attribute(copyright));
	}

}
