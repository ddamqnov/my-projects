<%--
  Created by IntelliJ IDEA.
  User: Damqnov
  Date: 14-4-5
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form role="form" id="add-ad-form" method="POST">
    <div class="form-group">
        <label for="ad-title-fld">Въведете заглавие на обявата:</label>
        <input type="text" class="form-control" id="ad-title-fld" name="ad-title"placeholder="Заглавие">
    </div>

    <div class="form-group">
        <label for="ad-select-category">Категория: </label>
        <select id="ad-select-category" name="ad-category">
            <option>Автомобили</option>
        </select>
    </div>

    <div class="form-group">
        <label for="ad-content-area">Описание на обявата</label>
        <textarea rows="5" cols="80" id="ad-content-area"  name="ad-content" placeholder="Съдържание..."></textarea>
    </div>
    <div class="form-group">
        <label for="input-image">Добавате изображение:</label>
        <input type="file" id="input-image">
    </div>
    <button type="submit" class="btn btn-info btn-lg">Добави</button>
</form>
