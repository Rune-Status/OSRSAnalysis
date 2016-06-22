package pw.tdekk.oldschool;

import pw.tdekk.visitor.GraphVisitor;
import pw.tdekk.visitor.VisitorInfo;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

@VisitorInfo(hooks = {"height"})
public class RenderableNode extends GraphVisitor {

    @Override
    public boolean validate(ClassNode cn) {
        return (cn.access & Opcodes.ACC_ABSTRACT) == Opcodes.ACC_ABSTRACT && cn.superName.equals(clazz("CacheableNode"));
    }

    @Override
    public void visit() {
        add("height", cn.getField(null, "I"), "I");
    }
}

