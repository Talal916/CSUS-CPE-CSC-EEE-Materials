add(BorderLayout.WEST, westContainer);
ThatReleasingClass eastContainer = new ThatReleasingClass(); eastContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.GREEN)); eastContainer.getAllStyles().setBgColor(ColorUtil.MAGENTA); eastContainer.getAllStyles().setPadding(250, 250, 250, 250); eastContainer.getAllStyles().setMargin(20, 20, 20, 20);
add(BorderLayout.EAST, eastContainer);
ThatDraggingClass centerContainer = new ThatDraggingClass(); centerContainer.getAllStyles().setMargin(20, 20, 20, 20); centerContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK)); add(BorderLayout.CENTER, centerContainer);
show();