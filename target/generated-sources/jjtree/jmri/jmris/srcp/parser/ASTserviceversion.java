/* Generated By:JJTree: Do not edit this line. ASTserviceversion.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package jmri.jmris.srcp.parser;

public
class ASTserviceversion extends SimpleNode {
  public ASTserviceversion(int id) {
    super(id);
  }

  public ASTserviceversion(SRCPParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SRCPParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=de159c82366e2ff38d095b75fe496377 (do not edit this line) */
