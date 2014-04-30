/* ***************************************************************************
    Copyright (C) Lowe's Companies, Inc.  All rights reserved.
    This file is for internal use only at Lowe's Companies, Inc., and should
    not be modified without permission from the Application Architecture team.
   ***************************************************************************/

package com.lowes.tiles.web.preparer;

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
public class PageHeadingViewPreparer implements ViewPreparer {
	
	private static Logger LogIt = LoggerFactory.getLogger(PageHeadingViewPreparer.class);

	/**
	 * Method execute.
	 * @param requestContext TilesRequestContext
	 * @param attributeContext AttributeContext
	 * @throws PreparerException
	 * @see org.apache.tiles.preparer.ViewPreparer#execute(TilesRequestContext, AttributeContext)
	 */
	public void execute(TilesRequestContext requestContext, AttributeContext attributeContext)
		throws PreparerException {

		LogIt.debug("Inside Page Heading View Preparer");
		String pageHeading = (String)requestContext.getRequestScope().get("pageHeading");
		attributeContext.putAttribute("pageHeading", new Attribute(pageHeading));
	}

}
