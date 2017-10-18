/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serlvets;

import edu.tecnopotify.entidades.Artista;
import edu.tecnopotify.entidades.Cliente;
import edu.tecnopotify.fabrica.Fabrica;
import edu.tecnopotify.interfaces.IControlador;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Servletimagenes extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;
    private String fileDirStr = null;
    private IControlador crl;

    @Override
    public void init() throws ServletException {
        String rootPath = System.getProperty("user.home");
        String relativePath = "imagenes-servlet";
        fileDirStr = rootPath + File.separator + relativePath;
        File filesDir = new File(fileDirStr);
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }

        DiskFileItemFactory fileFactory = new DiskFileItemFactory();
        fileFactory.setRepository(filesDir);
        this.uploader = new ServletFileUpload(fileFactory);
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException
//    {
//        String filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
//        File file = new File("/path/to/files", filename);
//        response.setHeader("Content-Type", getServletContext().getMimeType(filename));
//        response.setHeader("Content-Length", String.valueOf(file.length()));
//        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
//        Files.copy(file.toPath(), response.getOutputStream());
//    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName
                = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
        System.out.println("filename:" + fileName);

//        String fileName = request.getParameter("fileName");
        if (fileName == null || fileName.equals("")) {
            throw new ServletException("Debe cargar una Imagen");
        }
        File file = new File(fileDirStr + File.separator + fileName);
        if (!file.exists()) {
            throw new ServletException("La imagen no existe.");
        }
        System.out.println("Ubicacion::" + file.getAbsolutePath());
        ServletContext ctx = getServletContext();
        InputStream fis = new FileInputStream(file);
        String mimeType = ctx.getMimeType(file.getAbsolutePath());

        response.setContentType(mimeType != null ? mimeType
                : "application/octet-stream");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition",
                "attachment; filename=\"" + fileName + "\"");

        ServletOutputStream os = response.getOutputStream();
        byte[] bufferData = new byte[1024];
        int read = 0;
        while ((read = fis.read(bufferData)) != -1) {
            os.write(bufferData, 0, read);
        }
        os.flush();
        os.close();
        fis.close();
        System.out.println("Archivo descargado correctamente");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            throw new ServletException("Content type is not multipart/form-data");
        }

        response.setContentType("text/html");

        try {
            List<FileItem> fileItemsList;
            fileItemsList = uploader.parseRequest(request);
            Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
            while (fileItemsIterator.hasNext()) {
                //  System.out.println("Archivo::");
                FileItem fileItem = fileItemsIterator.next();
                /*     System.out.println("\tNombre=" + fileItem.getFieldName());
                System.out.println("\tNombre archivo=" + fileItem.getName());
                System.out.println("\ttipo=" + fileItem.getContentType());
                System.out.println("\tTamanio=" + fileItem.getSize());*/
                request.setAttribute("imagen", fileItem.getName());

                File file = new File(fileDirStr + File.separator + fileItem.getName());
                //System.out.println("Absolute Path at server=" + file.getAbsolutePath());
                fileItem.write(file);
                Fabrica fabrica = Fabrica.getInstance();
                crl = fabrica.getInstancia();
                String comando = request.getParameter("comando");
                if (comando.equals("altaCli")) {
                    Cliente cli = crl.getCli((String) request.getParameter("id"));
                    cli.setImagen(file.getAbsolutePath());
                    crl.setImageCli(cli);
                } else if (comando.equals("altaArt")) {
                    Artista art = crl.seleccionarArtista((String) request.getParameter("id"));

                    art.setImagen(file.getAbsolutePath());
                    crl.setImageArt(art);
                }
            }
        } catch (Exception e) {
            System.out.println("Error!");
        }
        RequestDispatcher despachador = request.getRequestDispatcher("/ppal.jsp");
        despachador.forward(request, response);
    }

}
