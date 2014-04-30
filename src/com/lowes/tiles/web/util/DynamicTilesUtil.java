/* ***************************************************************************
    Copyright (C) Lowe's Companies, Inc.  All rights reserved.
    This file is for internal use only at Lowe's Companies, Inc., and should
    not be modified without permission from the Application Architecture team.
   ***************************************************************************/

package com.lowes.tiles.web.util;

import org.springframework.web.servlet.ModelAndView;

/** <pre>
 * This class holds the Dynamic Tiles Utilities.
 * </pre>
 * 
 * @author  $Author: mcoffey $
 * @version $Revision: 1.1 $
 */
public class DynamicTilesUtil {

	/**
	 * Field POPUP_TEMPLATE_VAR.
	 * (value is ""_POPUP"")
	 */
	public static final String POPUP_TEMPLATE_VAR = "_POPUP";
	/**
	 * Field HELP_LINK.
	 * (value is ""helpLink"")
	 */
	public static final String HELP_LINK = "helpLink";
	private static final String POPUP_TEMPLATE_NAME = ".popupTemplate";

	/**
	 * Method setPopupTile.
	 * Call this method to set the view to use the popup template.
	 * @param modelAndView ModelAndView
	 */
	public static void setPopupTile(ModelAndView modelAndView) {

		modelAndView.addObject(POPUP_TEMPLATE_VAR, POPUP_TEMPLATE_NAME);
	}

}
