/* Generated By:JJTree: Do not edit this line. ASTdescription.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package jmri.jmrix.srcp.parser;

public
class ASTdescription extends SimpleNode {
  public ASTdescription(int id) {
    super(id);
  }

  public ASTdescription(SRCPClientParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SRCPClientParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=ccf753f151c3679a6e2a0f465f469082 (do not edit this line) */
