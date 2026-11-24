<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Add Car">
    <h1>Add Car</h1>

    <form class="needs-validation" novalidate method="POST"
          action="${pageContext.request.contextPath}/AddCar">

        <div class="row">

            <div class="col-md-6 mb-3">
                <label for="license_plate">License Plate</label>
                <input type="text" class="form-control"
                       id="license_plate" name="license_plate"
                       placeholder="" value="" required>

                <div class="invalid-feedback">
                    License Plate is required.
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label for="parking_spot">Parking Spot</label>
                <input type="text" class="form-control"
                       id="parking_spot" name="parking_spot"
                       placeholder="" value="" required>

                <div class="invalid-feedback">
                    Parking Spot is required.
                </div>
            </div>

            <div class="col-md-5 mb-3">
                <label for="owner_id">Owner</label>
                <select class="form-select" id="owner_id"
                        name="owner_id" required>

                    <option value="">Choose...</option>

                </select>

                <div class="invalid-feedback">
                    Please select an owner.
                </div>
            </div>

        </div>

        <hr class="my-4">

        <button class="w-100 btn btn-primary btn-lg" type="submit">
            Save
        </button>

    </form>
</t:pageTemplate>