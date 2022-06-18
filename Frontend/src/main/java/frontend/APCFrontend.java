package frontend;

import frontend.Model.APCFrontendModel;
import frontend.Model.FrontendModel;
import frontend.View.APCFrontendView;
import frontend.View.FrontendView;
import frontend.ViewModel.APCFrontendViewModel;
import frontend.ViewModel.FrontendViewModel;

public class APCFrontend implements FrontendFacade {
    private FrontendModel model;
    private FrontendViewModel viewModel;
    private FrontendView view;

    @Override
    public void launchMainWindow(String backendIP, int backendPort) {
        model = new APCFrontendModel();
        viewModel = new APCFrontendViewModel();
        view = new APCFrontendView();
        viewModel.setModel(model);
        view.setViewModel(viewModel);
        view.startTheApp(backendIP, backendPort);
    }

    @Override
    public void eliminateWindow() {
        // TODO Auto-generated method stub

    }
}
