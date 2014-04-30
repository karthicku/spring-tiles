// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.preferInterfacesToReflection
/* ***************************************************************************
    Copyright (C) Lowe's Companies, Inc.  All rights reserved.
    This file is for internal use only at Lowe's Companies, Inc., and should
    not be modified without permission from the Application Architecture team.
   ***************************************************************************/

package com.lowes.tiles.web.preparer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lowes.tiles.web.util.DynamicTilesUtil;

/**
 * This class takes the page heading from the request context and moves it to the
 * attribute context so the pageHeading.jsp fragment can get to it for rendering.
 * @author  $Author: mcoffey $
 * @version $Revision: 1.1 $
 */
public class AppHeadingViewPreparer implements ViewPreparer {
	
	private static Logger LogIt = LoggerFactory.getLogger(AppHeadingViewPreparer.class);
	private static final String NOT_AUTHENTICATED = "Not Authenticated";
	private static final String NO_LINK = "No Link";
	private static final Class<?>[] ZERO_CLASS_ARRAY = new Class[0];
	private static final Object[] ZERO_OBJECT_ARRAY = new Object[0];

	/**
	 * Method execute.
	 * @param requestContext TilesRequestContext
	 * @param attributeContext AttributeContext
	 * @throws PreparerException
	 * @see org.apache.tiles.preparer.ViewPreparer#execute(TilesRequestContext, AttributeContext)
	 */
	public void execute(TilesRequestContext requestContext, AttributeContext attributeContext)
		throws PreparerException {

		LogIt.debug("Inside App Heading View Preparer");
		Class<?> clazz = null;
		Method method = null;
		Object userDetails = null;
		try {
			clazz = Class.forName("com.lowes.shared.security.LowesUserDetailsService");
			LogIt.debug("The class " + clazz.getName() + " was found.");

			method = clazz.getMethod("loadUser", ZERO_CLASS_ARRAY);
			LogIt.debug("The method " + method.getName() + " was found.");

			userDetails = method.invoke(clazz, ZERO_OBJECT_ARRAY);
			if (userDetails != null) {
				LogIt.debug("The object " + userDetails.getClass().getName() + " was retrieved.");
				attributeContext.putAttribute("userDetails", new Attribute(userDetails));
				return;
			}
		} catch (ClassNotFoundException e) {
			LogIt.debug("", e);
		} catch (NoClassDefFoundError e ) {
			//A NoClassDefFoundError will happen when security is not implemented
			if (!e.getMessage().endsWith("UsernameNotFoundException")) {
				LogIt.debug("", e);
			}
		} catch (NoSuchMethodException e) {
			LogIt.error("", e);
		} catch (IllegalAccessException e) {
			LogIt.error("", e);
		} catch (InvocationTargetException e) {
			//A ClassCastException will happen until a user has logged in
			if (!e.getTargetException().getClass().getName().equals("java.lang.ClassCastException")) {
				LogIt.debug("", e);
			}
		}
		attributeContext.putAttribute("userDetails", new Attribute(NOT_AUTHENTICATED));
		
		if (requestContext.getRequestScope().containsKey(DynamicTilesUtil.HELP_LINK)) {
			attributeContext.putAttribute(DynamicTilesUtil.HELP_LINK,
					new Attribute(requestContext.getRequestScope().get(DynamicTilesUtil.HELP_LINK)));
		}
		else {
			attributeContext.putAttribute(DynamicTilesUtil.HELP_LINK, new Attribute(NO_LINK));
		}
	}

}
