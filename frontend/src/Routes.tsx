import Dashboard from "components/pages/Dashboard";
import Home from "components/pages/Home";
import { BrowserRouter, Switch, Route } from "react-router-dom";

function Routes(){
    return(
        <div>
            <BrowserRouter>
                <Switch>
                    <Route path="/" exact>
                        <Home />
                    </Route>

                    <Route path="/dashboard">
                        <Dashboard />
                    </Route>
                </Switch>
            
            
            
            </BrowserRouter>
           


        </div>
    );
}

export default Routes