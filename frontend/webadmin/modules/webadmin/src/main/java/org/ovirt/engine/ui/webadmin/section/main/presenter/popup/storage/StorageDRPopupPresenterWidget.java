package org.ovirt.engine.ui.webadmin.section.main.presenter.popup.storage;

import org.ovirt.engine.ui.common.presenter.AbstractModelBoundPopupPresenterWidget;
import org.ovirt.engine.ui.common.presenter.popup.DefaultConfirmationPopupPresenterWidget;
import org.ovirt.engine.ui.uicommonweb.models.storage.StorageDRModel;
import org.ovirt.engine.ui.uicompat.Event;
import org.ovirt.engine.ui.uicompat.EventArgs;
import org.ovirt.engine.ui.uicompat.IEventListener;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class StorageDRPopupPresenterWidget extends AbstractModelBoundPopupPresenterWidget<StorageDRModel, StorageDRPopupPresenterWidget.ViewDef> {
    @Inject
    public StorageDRPopupPresenterWidget(EventBus eventBus,
            ViewDef view,
            Provider<StorageDRPopupPresenterWidget> snapshotPopupProvider,
            Provider<DefaultConfirmationPopupPresenterWidget> defaultConfirmPopupPrivder) {
        super(eventBus, view);
    }

    @Override
    public void init(final StorageDRModel model) {
        super.init(model);

        model.getFrequency().getSelectedItemChangedEvent().addListener(new IEventListener<EventArgs>() {
            @Override
            public void eventRaised(Event<? extends EventArgs> ev, Object sender, EventArgs args) {
                getView().updateVisibilities(model);
            }
        });

    }

    public interface ViewDef extends AbstractModelBoundPopupPresenterWidget.ViewDef<StorageDRModel> {
        public void updateVisibilities(StorageDRModel object);
    }
}
