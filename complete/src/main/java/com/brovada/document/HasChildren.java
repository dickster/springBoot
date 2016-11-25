package com.brovada.document;

import java.util.List;

public interface HasChildren {

    List<? extends Component> getChildren();

}
