package spoon.support.gui;


public class SpoonObjectFieldsTable extends javax.swing.JFrame {
    public class SpoonObjectTableModel extends javax.swing.table.AbstractTableModel {
        private static final long serialVersionUID = 1L;

        java.util.List<java.lang.reflect.Field> field;

        java.lang.Object o;

        public SpoonObjectTableModel(java.lang.Object o) {
            super();
            this.o = o;
            field = new java.util.ArrayList<>();
            scanFields(o.getClass());
        }

        public int getColumnCount() {
            return spoon.support.gui.SpoonObjectFieldsTable.columnsName.length;
        }

        @java.lang.Override
        public java.lang.String getColumnName(int column) {
            return spoon.support.gui.SpoonObjectFieldsTable.columnsName[column];
        }

        public int getRowCount() {
            return field.size();
        }

        public java.lang.Object getValueAt(int rowIndex, int columnIndex) {
            java.lang.reflect.Field m = field.get(rowIndex);
            switch (columnIndex) {
                case 0 :
                    return m.getName();
                case 1 :
                    return m.getType().getCanonicalName();
                case 2 :
                    try {
                        java.lang.Object val = m.get(o);
                        if (val != null) {
                            return val.getClass().getCanonicalName();
                        }
                    } catch (java.lang.IllegalArgumentException | java.lang.IllegalAccessException e) {
                        spoon.Launcher.LOGGER.error(e.getMessage(), e);
                    }
                    break;
                case 3 :
                    try {
                        return m.get(o);
                    } catch (java.lang.IllegalArgumentException | java.lang.IllegalAccessException e) {
                        spoon.Launcher.LOGGER.error(e.getMessage(), e);
                    }
            }
            return null;
        }

        public void scanFields(java.lang.Class<?> c) {
            for (java.lang.reflect.Field f : c.getDeclaredFields()) {
                f.setAccessible(true);
                if (!(java.lang.reflect.Modifier.isStatic(f.getModifiers()))) {
                    field.add(f);
                }
            }
            if ((c.getSuperclass()) != null) {
                scanFields(c.getSuperclass());
            }
        }
    }

    public static final java.lang.String[] columnsName = new java.lang.String[]{ "Name", "FieldType", "currentType", "Value" };

    private static final long serialVersionUID = 1L;

    private javax.swing.JPanel jContentPane = null;

    private javax.swing.JScrollPane jScrollPane = null;

    private javax.swing.JTable jTable = null;

    private java.lang.Object o;

    public SpoonObjectFieldsTable(java.lang.Object o) {
        super();
        this.o = o;
        initialize();
    }

    private javax.swing.JPanel getJContentPane() {
        if ((jContentPane) == null) {
            jContentPane = new javax.swing.JPanel();
            jContentPane.setLayout(new java.awt.BorderLayout());
            jContentPane.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
        }
        return jContentPane;
    }

    private javax.swing.JScrollPane getJScrollPane() {
        if ((jScrollPane) == null) {
            jScrollPane = new javax.swing.JScrollPane();
            jScrollPane.setViewportView(getJTable());
        }
        return jScrollPane;
    }

    private javax.swing.JTable getJTable() {
        if ((jTable) == null) {
            jTable = new javax.swing.JTable(new spoon.support.gui.SpoonObjectFieldsTable.SpoonObjectTableModel(o));
        }
        return jTable;
    }

    private void initialize() {
        this.setSize(320, 240);
        this.setLocation((((getGraphicsConfiguration().getDevice().getDisplayMode().getWidth()) - (getWidth())) / 2), (((getGraphicsConfiguration().getDevice().getDisplayMode().getHeight()) - (getHeight())) / 2));
        this.setContentPane(getJContentPane());
        this.setTitle(o.getClass().getSimpleName());
        this.setVisible(true);
        this.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    }
}

