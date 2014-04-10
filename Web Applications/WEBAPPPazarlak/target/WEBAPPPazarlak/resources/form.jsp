<%--
  Created by IntelliJ IDEA.
  User: Damqnov
  Date: 14-3-26
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="form-horizontal"  role="form" id="reg-form" method="post">
    <div class="form-group">
        <div class="col-sm-10 col-sm-offset-1 input-group">
            <span class="input-group-addon">
                @
            </span>
            <input type="email" class="form-control" id="reg-email" placeholder="Имейл" name="reg-email">
        </div>
        <div class="text-danger col-sm-offset-1 " id="reg-email-err"></div>
    </div>
    <div class="form-group">
        <div class=" col-sm-offset-1 col-sm-10 input-group">
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-lock"></span>
            </span>
            <input type="password" class="form-control" id="reg-password" placeholder="Парола" name="reg-password">
        </div>
        <div class="text-danger col-sm-offset-1 " id="reg-password-err"></div>
    </div>
    <div class="form-group">
        <div class=" col-sm-offset-1 col-sm-10 input-group">
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-lock"></span>
            </span>
            <input type="password" class="form-control"  placeholder="Повторете паролата"  name="confirm-reg-password">
        </div>
        <div class="text-danger col-sm-offset-1 " id = "confirm-reg-password-err"></div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-3">
            <input id="terms-checkbox" type="checkbox" name="terms-checkbox">
            <label for="terms-checkbox">Съгласен съм с
                <a href="#" data-toggle="modal" data-target=".bs-example-modal-lg">Общите условия</a>
            </label>
        </div>
        <div class="text-danger col-sm-offset-3  " id="terms-checkbox-err"></div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-4 col-sm-4">
            <button id="reg-submit-btn" type="submit" class="btn btn-default">Регистрация</button>
        </div>
    </div>
</form>


<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <h3>Terms and Conditions of Use of www.pazarlak.com</h3>
            <p><b>1 &nbsp;Acceptance The Use Of www.pazarlak.com Terms and Conditions</b></p>
            <p>Your  access  to  and  use  of  www.pazarlak.com is  subject exclusively to these Terms and Conditions. You will not use the Website for any purpose that is unlawful or prohibited by these Terms and Conditions. By using  the  Website  you  are  fully  accepting  the  terms,  conditions  and disclaimers contained in this notice. If you do not accept these Terms and Conditions you must immediately stop using the Website.</p>

            <p><b>2 &nbsp;Credit card details</b></p>
            <p>www.pazarlak.com will never ask for Credit Card details and request that you do not enter it on any of the forms on www.pazarlak.com.</p>

            <p><b>3 &nbsp;Advice</b></p>
            <p>The contents of www.pazarlak.com website do not constitute advice and should not be relied upon in making or refraining from making, any decision.</p>

            <p><b>4 &nbsp;Change of Use</b></p>
            <p>www.pazarlak.com reserves the right to:<br /> 4.1 &nbsp;change or remove (temporarily or permanently) the Website or any part of it without notice and you confirm that www.pazarlak.com shall not be liable to you for any such change or removal and.<br /> 4.2 &nbsp;change these Terms and Conditions at any time, and your continued use of the Website following any changes shall be deemed to be your acceptance of such change.</p>

            <p><b>5 &nbsp;Links to Third Party Websites</b></p>
            <p>www.pazarlak.com Website may include links to third party websites that are controlled and maintained by others. Any link to other websites is not an endorsement of such websites and you acknowledge and agree that we are not responsible for the content or availability of any such sites.</p>

            <p><b>6 &nbsp;Copyright </b></p>
            <p>6.1 &nbsp;All  copyright,  trade  marks  and  all  other  intellectual  property  rights  in  the Website and its content (including without limitation the Website design, text, graphics and all software and source codes connected with the Website) are owned by or   licensed to www.pazarlak.com or otherwise used by www.pazarlak.com as permitted by law.<br /> 6.2 &nbsp;In accessing the Website you agree that you will access the content solely for your personal, non-commercial use. None of the content may be downloaded, copied, reproduced, transmitted, stored, sold or distributed without the prior written consent of the copyright holder. This excludes the downloading, copying and/or printing of pages of the Website for personal, non-commercial home use only.</p>

            <p><b>7 &nbsp;Disclaimers and Limitation of Liability </b></p>
            <p>7.1 &nbsp;The Website is provided on an AS IS and AS AVAILABLE basis without any representation or endorsement made and without warranty of any kind whether express or implied, including but not limited to the implied warranties of satisfactory quality, fitness for a particular purpose, non-infringement, compatibility, security and accuracy.<br /> 7.2 &nbsp;To the extent permitted by law, www.pazarlak.com will not be liable for any indirect or consequential loss or damage whatever (including without limitation loss of business, opportunity, data, profits) arising out of or in connection with the use of the Website.<br /> 7.3 &nbsp;www.pazarlak.com makes no warranty that the functionality of the Website will be uninterrupted or error free, that defects will be corrected or that the Website or the server that makes it available are free of viruses or anything else which may be harmful or destructive.<br /> 7.4 &nbsp;Nothing in these Terms and Conditions shall be construed so as to exclude or limit the liability of www.pazarlak.com for death or personal injury as a result of the negligence of www.pazarlak.com or that of its employees or agents.</p>

            <p><b>8 &nbsp;Indemnity</b></p>
            <p>You agree to indemnify and hold www.pazarlak.com and its employees and agents harmless from and against all liabilities, legal fees, damages, losses, costs and other expenses in relation to any claims or actions brought against www.pazarlak.com arising out of any breach by you of these Terms and Conditions or other liabilities arising out of your use of this Website.</p>

            <p><b>9 &nbsp;Severance</b></p>
            <p>If any of these Terms and Conditions should be determined to be invalid, illegal or unenforceable for any reason by any court of competent jurisdiction then such Term or Condition shall be severed and the remaining Terms and Conditions shall survive and remain in full force and effect and continue to be binding and enforceable.</p>

            <p><b>10 &nbsp;Governing Law</b></p>
            <p>These Terms and Conditions shall be governed by and construed in accordance with the law of USA and you hereby submit to the exclusive jurisdiction of the USA courts.</p>

            For any further information please email <a href='mailto:example@email.bg'>webmaster</a>
            <!--Terms and conditions generator from http://madsubmitter.com-->
        </div>
    </div>
</div>
