import { Route, Routes, Navigate } from "react-router";
import Login from "../../components/Login/Login";
import ResetPassword from '../../components/ResetPassword/ResetPassword';
import ChangePassword from '../../components/ChangePassword/ChangePassword';

import Register from "../../components/Register/Register";
import VerifyEmail from "../../components/VerifyEmail/VerifyEmail";
import Properties from "../Properties/Properties";
import PropertyDetail from "../../components/PropertyDetail/PropertyDetail";
import ProtectedComponent from "../../components/ProtectedComponent/ProtectedComponent";
import { ADMIN, OWNER } from "../../constants/roles";
import AddNewProperty from "../../components/AddNewProperty/AddNewProperty";
import Admin from "../Admin/Admin";
import HomeNavigator from "../../components/HomeNavigator/HomeNavigator";
import User from "../../components/User/User";
import OwnerProperties from "../../components/OwnerProperties/OwnerProperties";


const PageRoutes = (props) => {

    return (
        <Routes>
            <Route path='/' element={<HomeNavigator />} />
            <Route path='register' element={<Register />} />
            <Route path='login' element={<Login />} />
            <Route path='reset-password' element={<ResetPassword />} />
            <Route path='change-password' element={<ChangePassword />} />
            <Route path='verify-email' element={<VerifyEmail />} />
            <Route path='properties' element={<Properties />} />
            <Route path="properties/:id" element={<PropertyDetail />} />
            <Route
                path="properties/new"
                element={<ProtectedComponent requiredRole={OWNER} component={<AddNewProperty />} />}
            />
            <Route
                path="properties/new"
                element={<ProtectedComponent requiredRole={OWNER} component={<AddNewProperty />} />}
            />

            <Route
                path="admin"
                element={<ProtectedComponent requiredRole={ADMIN} component={<Admin />} />}
            />

            <Route
                path="admin/users"
                element={<ProtectedComponent requiredRole={ADMIN} component={<User />} />}
            />

            <Route
                path="admin/users/:userId/properties"
                element={<ProtectedComponent requiredRole={ADMIN} component={<OwnerProperties />} />}
            />

        </Routes>

    );

}

export default PageRoutes;