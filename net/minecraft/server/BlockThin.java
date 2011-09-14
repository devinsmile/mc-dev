package net.minecraft.server;

import java.util.ArrayList;

public class BlockThin extends Block {

    private int a;

    protected BlockThin(int i, int j, int k, Material material) {
        super(i, j, material);
        this.a = k;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public void a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist) {
        boolean flag = this.c(world.getTypeId(i, j, k - 1));
        boolean flag1 = this.c(world.getTypeId(i, j, k + 1));
        boolean flag2 = this.c(world.getTypeId(i - 1, j, k));
        boolean flag3 = this.c(world.getTypeId(i + 1, j, k));

        if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1)) {
            if (flag2 && !flag3) {
                this.a(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
                super.a(world, i, j, k, axisalignedbb, arraylist);
            } else if (!flag2 && flag3) {
                this.a(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
                super.a(world, i, j, k, axisalignedbb, arraylist);
            }
        } else {
            this.a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.a(world, i, j, k, axisalignedbb, arraylist);
        }

        if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1)) {
            if (flag && !flag1) {
                this.a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
                super.a(world, i, j, k, axisalignedbb, arraylist);
            } else if (!flag && flag1) {
                this.a(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
                super.a(world, i, j, k, axisalignedbb, arraylist);
            }
        } else {
            this.a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
            super.a(world, i, j, k, axisalignedbb, arraylist);
        }
    }

    public void a(IBlockAccess iblockaccess, int i, int j, int k) {
        float f = 0.4375F;
        float f1 = 0.5625F;
        float f2 = 0.4375F;
        float f3 = 0.5625F;
        boolean flag = this.c(iblockaccess.getTypeId(i, j, k - 1));
        boolean flag1 = this.c(iblockaccess.getTypeId(i, j, k + 1));
        boolean flag2 = this.c(iblockaccess.getTypeId(i - 1, j, k));
        boolean flag3 = this.c(iblockaccess.getTypeId(i + 1, j, k));

        if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1)) {
            if (flag2 && !flag3) {
                f = 0.0F;
            } else if (!flag2 && flag3) {
                f1 = 1.0F;
            }
        } else {
            f = 0.0F;
            f1 = 1.0F;
        }

        if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1)) {
            if (flag && !flag1) {
                f2 = 0.0F;
            } else if (!flag && flag1) {
                f3 = 1.0F;
            }
        } else {
            f2 = 0.0F;
            f3 = 1.0F;
        }

        this.a(f, 0.0F, f2, f1, 1.0F, f3);
    }

    public final boolean c(int i) {
        return Block.o[i] || i == this.id || i == Block.GLASS.id;
    }
}
