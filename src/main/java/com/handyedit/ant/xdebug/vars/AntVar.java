package com.handyedit.ant.xdebug.vars;

import com.handyedit.ant.util.StringUtil;
import com.intellij.icons.AllIcons;
import com.intellij.xdebugger.frame.XNamedValue;
import com.intellij.xdebugger.frame.XValue;
import com.intellij.xdebugger.frame.XValueNode;
import com.intellij.xdebugger.frame.XValuePlace;
import org.jetbrains.annotations.NotNull;

/**
 * Variable renderer for the variables section (execution stack on the debugger tool window).
 *
 * @author Alexei Orischenko
 *         Date: Nov 11, 2009
 */
public class AntVar extends XNamedValue {

    private String myName;
    private String myValue;

    public AntVar(String name, String value) {
        super(name);
        myName = name;
        myValue = value;
    }

    @Override
    public void computePresentation(@NotNull XValueNode node, @NotNull XValuePlace place) {

      //Is this the same as import com.intellij.xdebugger.ui.DebuggerIcons.VALUE_ICON?
        if (myValue != null) {
            node.setPresentation(AllIcons.Debugger.Value,"java.lang.String",myName, StringUtil.quote(myValue), false);
        } else {
            node.setPresentation(AllIcons.Debugger.Value,"java.lang.String",myName, "null", false);
        }
    }
}
