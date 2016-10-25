package com.simon.components;

public class TestPanel extends org.zkoss.zul.Button {

    private static final long serialVersionUID = 1L;

    private String icon;

    int count = 0;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
        smartUpdate("icon", icon);
    }

    protected void renderProperties(org.zkoss.zk.ui.sys.ContentRenderer renderer) throws java.io.IOException {
        super.renderProperties(renderer);
        render(renderer, "icon", icon);
        setTitle();
        // this.addEventListener("onClick", new EventListener<Event>() {
        //
        // @Override
        // public void onEvent(Event event) throws Exception {
        // // TODO Auto-generated method stub
        // setTitle();
        // }
        //
        // });

    }

    // @Listen("onClick")
    // @org.zkoss.spring.context.annotation.EventHandler("onClick")
    public void setTitle() {
        this.setLabel("Button clicked " + +count);
    }
}