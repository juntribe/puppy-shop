
function bindDomEvent(){
    $(".custom-file-input").on("change",function (){
        var fileName = $(this).val().split("//").pop();
        var fileExt = fileName.substring(fileName.lastIndexOf('.')+1);

        fileExt = fileExt.toLowerCase();

        if (fileExt !== "jpg"&& fileExt !== "jpeg" && fileExt !== "gif" && fileExt!=="png" && fileExt !== "bmp"){
            alert("이미지 파일만 등록이 가능합니다.")
            return;
        }
        $(this).sibling(".custom-file-label").html(fileName);
    })


}

function addExtraImagesSection(){
    html =' <tr>\n' +
        '                    <th><span>이미지</span></th>\n' +
        '                    <td colspan="3">\n' +
        '                        <div class="">\n' +
        '                            <input type="file" name="itemImgFile" id="input_test" onclick="addExtraImagesSection()">\n' +
        '                        </div>\n' +
        '                    </td>\n' +
        '                </tr> '
    ;
    test = $("input[id=input_test]").length;
    console.log(test);
    if (test <4){
        $("#test_code").append(html);
    }
}