/* Generated By:JJTree: Do not edit this line. ASTturnoutdevice.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package jmri.jmris.simpleserver.parser;

public
class ASTturnoutdevice extends SimpleNode {
  public ASTturnoutdevice(int id) {
    super(id);
  }

  public ASTturnoutdevice(JmriServerParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(JmriServerParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=6b08eb3053d933cc4115b9d97e700494 (do not edit this line) */
